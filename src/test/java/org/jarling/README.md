# Tests

Jarling includes some basic tests to make sure our understanding of the APIs is correct, and to ensure our interaction with them is successful.

## Setup

To run tests, you need to create the file `<project root>/cfg/sandbox.properties`, which should look like this:
```properties
starling.access.token=<user access token>

# signature-protected endpoints require the following to be configured
# See [Generating keys] below if you do not have any keys configured
starling.signing.public-key-uid=<UID of the public key you are using, found in the Starling developer portal>
starling.signing.private-key=<path to corresponding PKCS8 (a.k.a. DER) private key>
starling.signing.key-algorithm=<RSA or ECDSA as appropriate>

# To test the "create payment with new payee" endpoint, you need to
# configure a valid, real, non-Starling UK bank account:
user.bank.account-number=<account number>
user.bank.sort-code=<sort code>
```

## Results

Tests can have any of three results:
- ✔ Pass: everything is working as expected, hooray!
- ❌ Fail: Something is wrong - either in our configuration, our code, or with Starling's API (e.g. the servers are down)
- ➖ Ignored: The tests wouldn't make sense in the current context. For example, a test for business accounts doesn't make sense when applied to an individual account.

## Generating keys

If you do not have signing keys configured for your application yet, you can generate some by running this script:

```bash
openssl genrsa -out private_key.pem 2048
openssl genrsa -out key_rotation_private_key.pem 2048
openssl rsa -in private_key.pem -outform PEM -pubout -out public_key.pem
openssl rsa -in key_rotation_private_key.pem -outform PEM -pubout -out key_rotation_public_key.pem
openssl rsa -inform PEM -outform DER -text -in private_key.pem -out private_key.der
```

1. Store the resulting files somewhere very safe. In particular **do not lose** `key_rotation_private_key.pem` or you will have to throw away your Starling application registration and start again. The same applies if it falls into the wrong hands.
2. Configure [your Starling application](https://developer.starlingbank.com/application/list) with `public_key.pem` and `key_rotation_public_key.pem` by copying the entire contents of each file into the relevant prompts. The key type is "RSA" in both cases.
3. The application configuration page will now report a UID for the public key you just uploaded. This, along with `private_key.der`, is what you should configure in `cfg/sandbox.properties`
