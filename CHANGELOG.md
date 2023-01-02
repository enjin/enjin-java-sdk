# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

## [2.0.0-beta.2] - 2023-01-02

### Added

- Added `UpdateName` request to `IProjectSchema`.

### Fixed

- Fixed GraphQL template argument type for `BridgeClaimAsset`.

## [2.0.0-beta.1] - 2022-07-18

### Added

- Added `HttpLogLevel` enum values.
- Added `IAuthenticationEventListener`.
- Added reauthentication features to `ProjectClient`.

### Changed

- Renamed `AssetSort` to `AssetSortInput`.
- Renamed `Melt` to `MeltInput`.
- Renamed `PaginationOptions` to `PaginationInput`.
- Renamed `Request` to `Transaction`.
- Renamed `RequestState` to `TransactionState`.
- Renamed `RequestType` to `TransactionType`.
- Renamed `Trade` to `TradeInput`.
- Renamed `TransactionSort` to `TransactionSortInput`.
- Renamed `Transfers` to `TransferInput`.
- Renamed `GetRequest` to `GetTransaction`.
- Renamed `GetRequests` to `GetTransactions`.
- Renamed `ProjectTransactionRequestArguments` to `TransactionRequestArguments`.
- Renamed `TrustedPlatformMiddleware` to `ClientMiddleware`.
- Renamed `TrustedPlatformInterceptor` to `ClientInterceptor`.
- Renamed `Channel` to `IChannel`.
- Renamed `NotificationService` to `IEventService`.
- Renamed `NotificationListener` to `IEventListener`.
- Renamed `EventMatcher` to `IEventMatcher`.
- Renamed `ConnectionEventListener` to `IConnectionEventListener`.
- Renamed `PusherNotificationService` to `PusherEventService`.
- Renamed `NotificationListenerRegistration` to `EventListenerRegistration`.
- Renamed `RequestService` to `TransactionService`.
- Renamed `RequestTypeDeserializer` to `TransactionTypeDeserializer`.
- `ClientInterceptor` now locks its authentication token with a mutex.
- Changed type of `AccessToken.expiresIn` from primitive to wrapper class.
- Platform clients and event services now utilize builders.
- Replaced async and sync platform request methods in clients with a singular request method which returns a future.
- Replaced Boolean input to set HTTP debugging in platform clients and middleware with `HttpLogLevel` enum.
- The logger provider passed to the platform clients now handles HTTP logs when HTTP debugging is enabled.
- Retrofit services now return a future instead of a call instance.
- Event listeners now implement `java.util.EventListener`.
- `PusherEventService` is now in the package-protected scope instead of public.

### Removed

- Removed constructors from platform clients and event services.
- Removed `HttpCallback` interface and `HttpResponse` class.

## [2.0.0-alpha.10] - 2022-07-05

### Added

- Added `GOERLI` to `EnjinHosts`.

### Removed

- Removed `KOVAN` from `EnjinHosts`.

## [2.0.0-alpha.9] - 2022-05-23

### Added

- Added arguments and fields to `Transaction.gql` template file for getting the wallet address.
- Added arguments and fields to `Wallet.gql` template file for getting balances and transactions.
- Added `withTransactionWalletAddress` method to `TransactionFragmentArguments`.
- Added `walletBalanceFilter`, `withWalletBalances`, `withWalletTransactions`, and methods to `WalletFragmentArguments`.
- Added field and getter for wallet object to `Request` model.
- Added fields and getters for list balances and list transactions to `Wallet` model.

### Changed

- Updated Gson to `2.9.0`.
- Changed name of method `assetIdFormat` in `TransactionFragmentArguments` to `transactionAssetIdFormat`.
- `WalletFragmentArguments` now extends `BalanceFragmentArguments` and `TransactionFragmentArguments`.

## [2.0.0-alpha.8] - 2022-04-25

### Changed

- Removed `projectUuid` and `projectUuidIn` methods from `BalanceFilter`.

## [2.0.0-alpha.7] - 2022-04-11

### Changed

- `GetWallets` query in project schema no longer implements `PaginationArguments`.

### Fixed

- Fixed typo for `result` in `GetWallets.gql` template file for project schema.
- Updated Gradle plugin `org.ajoberstar.git-publish` to `3.0.1`.

## [2.0.0-alpha.6] - 2022-01-13

### Fixed

- Updated Log4j 2 to version `2.17.1` to address security vulnerability in plugin.

## [2.0.0-alpha.5] - 2021-12-13

### Fixed

- Updated Log4j 2 to version `2.15.0` to address security vulnerability in plugin.

## [2.0.0-alpha.4] - 2021-11-09

### Added

- Added [Enjin Bridge mutations](https://docs.enjin.io/enjin-api/sending-and-receiving-requests/enjin-bridge) for
  project and player schemas.

## [2.0.0-alpha.3] - 2021-10-13

### Added

- Added `getAsset` method to `Request`.
- Added `assetIdFormat` method to `TransactionFragmentArguments`.

### Changed

- The asset for transactions is now included in returned `Request` models when using `withAssetData()` in requests which
  implement `TransactionFragmentArguments`.

## [2.0.0-alpha.2] - 2021-10-05

### Fixed

- Fixed error caused by recursive calls made within `AccessToken.toString()`.

## [2.0.0-alpha.1] - 2021-09-28

### Added

- Introduced support for the new V2 Platform Schemas (Player and Project).
- Added `EnjinHosts` utility class.
- Added `LogLevel` enum class.
- Added `ILogger` interface as well as `Logger` class as a built-in implementation.
- Added `getNamespace` method to `GraphQLRequest`.
- Added `onException` method to `HttpCallback`.
- Added `getKey`, `getChannels`, and `getFromKey` methods to `EventType`.
- Added `ConnectionEventListener` that may be used in classes which implement `NotificationsService` to listen for
  events related to the service's connection status.
- Added override for `debug` method in `LoggerProvider` to accept log an exception at the debug level.

### Changed

- Changed package structure throughout the SDK.
- Replaced universal platform client with dedicated clients for the player and project schemas which implement `IClient`
  and schema classes that have access only to requests utilized by their schema.
- Replaced `GraphQLVariableHolder` with `VariableHolder`.
- Overrode `equals` and `hashCode` methods in `GraphQLError` to utilize instance attributes.
- Overrode `equals` and `hashCode` methods in `GraphQLResponse` to utilize instance attributes.
- Overrode `equals` and `hashCode` methods in model classes to utilize instance attributes.
- Constructors for `GraphQLRequest` now have an additional parameter `namespace`.
- `GraphQLRequest.set` method now accepts null objects for `value`.
- `NotificationEvent` uses single constructor instead of builder pattern.
- Changed values in `EventType` to reflect cloud events for the V2 Platform instead of the V1 Platform.
- Changed `NotificationsService` to support subscribing for cloud events related to the V2 Platform instead of the V1
  Platform.
- `NotificationsService` returns a void future for `start` and `stop` methods.
- `NotificationsService` automatically resubscribes to channels when restarted.
- `PusherNotificationService` no longer creates its own default `LoggerProvider` instance in cases where one is not
  provided.
- `LoggerProvider` now utilizes `ILogger` and its `LogLevel` values instead of Java.Util's `Logger` and its `Level`
  values.

### Removed

- Removed support for the V1 Platform Schema (Default).
- Removed example platform server.
- Removed `getEventType` method from `EventType`.
- Removed `setDebug` method from `LoggerProvider`.

## [1.0.10] - 2022-07-05

### Added

- Added `GOERLI` host to `TrustedPlatformClientBuilder`.

### Deprecated

- Marked `KOVAN` host in `TrustedPlatformClientBuilder` as deprecated.

## [1.0.9] - 2022-05-23

### Changed

- Updated Gson to `2.9.0`.

## [1.0.8] - 2022-03-28

### Fixed

- Updated Gradle plugin `org.ajoberstar.git-publish` to `3.0.1`

## [1.0.7] - 2021-10-15

### Changed

- Replaced git-submodules for templates with included template files.

### Fixed

- Fixed type of `Transaction.getAccepted()`.

## [1.0.6] - 2021-07-29

### Changed

- Reset template submodule branch to `master`.
- Updated Gradle to `7.1.1`.

## [1.0.5] - 2021-07-22

### Added

- Added `AppOtionsData` input class.
- Added `TokenVarientMode` enum class.
- Added `GasPrices` model.
- Added `GetGasPrices` query.
- Added `BalanceFilter` input class and new `filter` method to `GetBalances` query to set the filter.
- Added `TokenFilter` input class and new `filter` method to `GetTokens` query to set the filter.
- Added `options` method to `UpdateApp`.
- Added `getApp` method to `Balance`.
- Added `getUser` method to `Identity`.
- Added `withIdentityUser` method to `IdentityFragment`.
- Added `transferable` method to `GetTokens`.
- Added `getMetadata` and `getVariantMode` methods to `Token`.
- Added `withMetadata` and `withVariantMode` methods to `TokenFragment`.
- Added `getToken` and `getTransaction` methods to `TokenEvent`.
- Added `withEventTransaction` to `TokenEventFragment`.
- Added `getApp` to `User`.
- Added `userAppId` to `UserFragment`.

### Changed

- Changed template submodule to use `development` branch.

### Deprecated

- Deprecated old filter methods in `GetBalances` query.

## [1.0.4] - 2020-08-12

### Fixed

- Fixed return type for of `deleteRequest` methods.
- Updated template submodule to correct commit.

## [1.0.3] - 2020-07-03

### Fixed

- Fixed authentication not being cleared when attempting to reauthenticate a platform client.

## [1.0.2] - 2020-06-05

### Added

- Added methods to `TrustedPlatformClient` to set auth token.

## [1.0.1] - 2020-06-01

### Fixed

- Fixed duplicate parameters in compiled templates.

## [1.0.0] - 2020-05-27

### Added

- Initial release.

[Unreleased]: https://github.com/enjin/enjin-java-sdk/compare/2.0.0-beta.2...HEAD

[2.0.0-beta.2]: https://github.com/enjin/enjin-java-sdk/compare/2.0.0-beta.1...2.0.0-beta.2

[2.0.0-beta.1]: https://github.com/enjin/enjin-java-sdk/compare/2.0.0-alpha.10...2.0.0-beta.1

[2.0.0-alpha.10]: https://github.com/enjin/enjin-java-sdk/compare/2.0.0-alpha.9...2.0.0-alpha.10

[2.0.0-alpha.9]: https://github.com/enjin/enjin-java-sdk/compare/2.0.0-alpha.8...2.0.0-alpha.9

[2.0.0-alpha.8]: https://github.com/enjin/enjin-java-sdk/compare/2.0.0-alpha.7...2.0.0-alpha.8

[2.0.0-alpha.7]: https://github.com/enjin/enjin-java-sdk/compare/2.0.0-alpha.6...2.0.0-alpha.7

[2.0.0-alpha.6]: https://github.com/enjin/enjin-java-sdk/compare/2.0.0-alpha.5...2.0.0-alpha.6

[2.0.0-alpha.5]: https://github.com/enjin/enjin-java-sdk/compare/2.0.0-alpha.4...2.0.0-alpha.5

[2.0.0-alpha.4]: https://github.com/enjin/enjin-java-sdk/compare/2.0.0-alpha.3...2.0.0-alpha.4

[2.0.0-alpha.3]: https://github.com/enjin/enjin-java-sdk/compare/2.0.0-alpha.2...2.0.0-alpha.3

[2.0.0-alpha.2]: https://github.com/enjin/enjin-java-sdk/compare/2.0.0-alpha.1...2.0.0-alpha.2

[2.0.0-alpha.1]: https://github.com/enjin/enjin-java-sdk/compare/v1.0.9...2.0.0-alpha.1

[1.0.10]: https://github.com/enjin/enjin-java-sdk/compare/v1.0.9...v1.0.10

[1.0.9]: https://github.com/enjin/enjin-java-sdk/compare/v1.0.8...v1.0.9

[1.0.8]: https://github.com/enjin/enjin-java-sdk/compare/v1.0.7...v1.0.8

[1.0.7]: https://github.com/enjin/enjin-java-sdk/compare/v1.0.6...v1.0.7

[1.0.6]: https://github.com/enjin/enjin-java-sdk/compare/v1.0.5...v1.0.6

[1.0.5]: https://github.com/enjin/enjin-java-sdk/compare/v1.0.4...v1.0.5

[1.0.4]: https://github.com/enjin/enjin-java-sdk/compare/v1.0.3...v1.0.4

[1.0.3]: https://github.com/enjin/enjin-java-sdk/compare/v1.0.2...v1.0.3

[1.0.2]: https://github.com/enjin/enjin-java-sdk/compare/v1.0.1...v1.0.2

[1.0.1]: https://github.com/enjin/enjin-java-sdk/compare/v1.0.0...v1.0.1

[1.0.0]: https://github.com/enjin/enjin-java-sdk/releases/tag/v1.0.0