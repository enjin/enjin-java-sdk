# Blockchain SDK by Enjin for Java

Create blockchain video games and applications using the Java programming language.

[Learn more](https://enjin.io/) about the Enjin blockchain platform.

Sign up to Enjin Cloud: [Kovan (Testnet)](https://kovan.cloud.enjin.io/),
[Mainnet (Production)](https://cloud.enjin.io/) or [JumpNet](https://jumpnet.cloud.enjin.io/).

### Resources

* [Enjin Docs](https://docs.enjin.io)
* [Java Docs](https://enjin.github.io/enjin-java-sdk/sdk/latest/)

### Table of Contents

* [Compatibility](#compatibility)
* [Installation](#installation)
    * [Maven](#maven)
    * [Gradle](#gradle)
    * [Git](#git)
* [Example Project](#example-project)
* [Contributing](#contributing)
    * [Issues](#issues)
    * [Pull Requests](#pull-requests)
* [Deploying](#deploying)
* [Copyright and Licensing](#copyright-and-licensing)

## Compatibility

The Enjin Java SDK requires at a minimum Java 8.

## Installation

### Maven

```xml
<dependency>
    <groupId>com.enjin</groupId>
    <artifactId>blockchain-sdk</artifactId>
    <version>1.0.9</version>
</dependency>
```

### Gradle

```groovy
dependencies {
    implementation 'com.enjin:blockchain-sdk:1.0.9'
}
```

### Git

For those that do not use Maven or Gradle, the SDK may be built manually and added to your project's classpath.

1. Clone the Java SDK repository using git.
2. Build the Java SDK:
    * `./gradlew sdk:build` (Linux)
    * `./gradlew.bat sdk:build` (Windows)
3. Navigate to the `build/libs` folder in the `sdk` module.
4. Add the jar ending in `-all` to your project's classpath.

## Example Project

### Create the Example Project

1. Register if you have not done so already.
2. Select `Create Project` from the `Platform` page.
3. Give the project a name and description (the image is optional).
4. Select `Save Changes` to create the project.

### Create Example Assets

1. Open your project by selecting it from the `Platform` page.
2. Go to `Assets` and select create `Create Asset`.
3. Set the name, total supply, value per asset, ENJ returned on melt, and the starting supply. All other details may be
   left as their default values.
4. Select `Create Asset`.

### Configuring the Example

Next we need the required details to use for our project. You will need the project's UUID, the project's secret, and
the IDs of the assets you created.

#### Getting the Project UUID and Secret

To get the ID and secret of your project by using the query below on the Enjin GraphQL Playground.

```graphql
query {
  EnjinApp {
    id
    secret
    identity {
      wallet {
        ethAddress
      }
    }
  }
}
```

#### Getting the Asset IDs

You can find the IDs of the assets you created by going to the `Assets` tab of your project. The IDs are under the
`Item ID` column.

## Contributing

Contributions to the SDK are appreciated!

### Issues

You can open issues for bugs and enhancement requests.

### Pull Requests

If you make any changes or improvements to the SDK, which you believe are beneficial to others, consider making a pull
request to merge your changes to be included in the next release.

Ensure that tests under the `sdk` module are passing and add any necessary test classes or test cases for your code.

Be sure to include your name in the list of contributors.

## Deploying

To deploy to maven central you should set the following in your `local.properties`.

```properties
deployment.username=<username>
deployment.password=<password>
```

GPG signing is required to publish release builds to Maven Central. You must configure the following in
`local.properties`.

```properties
signing.gnupg.keyName=<last 8 characters of key>
signing.gnupg.passphrase=<key passphrase>
```

## Copyright and Licensing

The license summary below may be copied.

```text
Copyright 2021 Enjin Pte. Ltd.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
