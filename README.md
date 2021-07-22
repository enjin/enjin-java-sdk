# Blockchain SDK by Enjin for Java
Create blockchain video games and applications using the Java programming language.

[Learn more](https://enjin.io/) about the Enjin blockchain platform.

Sign up to Enjin Cloud: [Kovan (Testnet)](https://kovan.cloud.enjin.io/) or [Mainnet (Production)](https://cloud.enjin.io/)

Documentation
=================
   * [Getting Started](https://docs.enjin.io/java-getting-started/)
   * [Authentication](https://docs.enjin.io/java-authentication/)
   * [Player Management](https://docs.enjin.io/java-player-management/)
   * [Creating Requests](https://docs.enjin.io/java-creating-requests/)

Deploying
=================
To deploy to maven central you should set the following in your `local.properties`.

```properties
deployment.username=<username>
deployment.password=<password>
```

GPG signing is required to publish release builds to Maven Central. You must configure the following in `local.properties`.

```properties
signing.gnupg.keyName=<last 8 characters of key>
signing.gnupg.passphrase=<key passphrase>
```
