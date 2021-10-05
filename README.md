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
* [Quick Start](#quick-start)
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
    <version>2.0.0-alpha.1</version>
</dependency>
```

### Gradle

```groovy
dependencies {
    implementation 'com.enjin:blockchain-sdk:2.0.0-alpha.1'
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

## Quick Start

This example showcases how to quickly create and authenticate a client on the project schema which will then allow us to
make further requests to the platform.

```java
import com.enjin.sdk.EnjinHosts;
import com.enjin.sdk.ProjectClient;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.models.AccessToken;
import com.enjin.sdk.schemas.project.queries.AuthProject;

public class Main {

    public static void main(String... args) {
        // Builds the project client to run on the Kovan test network.
        // See: https://kovan.cloud.enjin.io to sign up for the test network.
        ProjectClient client = ProjectClient.builder()
                                            .BaseUri(EnjinHosts.KOVAN)
                                            .build();

        // Creates the request to authenticate the client.
        // Replace the appropriate strings with the project's UUID and secret.
        AuthProject req = new AuthProject()
                .uuid("<the-project's-uuid>")
                .secret("<the-project's-secret>");

        // Sends the request to the platform and gets the response.
        GraphQLResponse<AccessToken> res = client.authProject(req);

        // Checks if the request was successful.
        if (!res.isSuccess()) {
            System.out.println("AuthProject request failed");
            client.close();
            return;
        }

        // Authenticates the client with the access token in the response.
        client.auth(res.getData().getToken());

        // Checks if the client was authenticated.
        if (client.isAuthenticated()) {
            System.out.println("Client is now authenticated");
        } else {
            System.out.println("Client was not authenticated");
        }

        // Closes client as part of cleanup and free any resources.
        client.close();
    }

}
```

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
