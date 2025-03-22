
# Loan Management System Project Structure

## Overview
This document provides an overview of the Loan Management System (LMS) project structure for quick reference during implementation.

## Root Structure
```css
loan-management-system/
├── pom.xml                    # Maven project configuration
├── README.md                  # Project documentation
├── src/                       # Source code
├── aws/                       # AWS deployment resources
└── docs/                      # Documentation
```

## Source Code Structure

```css
src/
├── main/                      # Main application code
│   ├── java/                  # Java source files
│   │   └── com/
│   │       └── credable/
│   │           └── lms/       # Root package
│   └── resources/             # Resource files
└── test/                      # Test code
```
## Main Application Components

```css
com/credable/lms/
├── LoanManagementApplication.java       # Main application class
├── config/                              # Configuration classes
├── controller/                          # REST controllers
├── dto/                                 # Data Transfer Objects
├── exception/                           # Exception classes
├── lambda/                              # AWS Lambda handlers
├── model/                               # Domain models
├── repository/                          # Data repositories
├── service/                             # Business logic services
├── client/                              # External system clients
├── messaging/                           # Messaging components
└── util/                                # Utility classes
```
## Detailed Component Breakdown

### Configuration (`config/`)
- `ActuatorConfig.java` - Monitoring configuration
- `AwsConfig.java` - AWS services configuration
- `RetryConfig.java` - Retry mechanism configuration
- `SecurityConfig.java` - Security settings
- `SoapConfig.java` - SOAP client configuration
- `SwaggerConfig.java` - API documentation

### Controllers (`controller/`)
- `LoanController.java` - Loan endpoints
- `SubscriptionController.java` - Subscription endpoint
- `TransactionController.java` - Transaction endpoints

### DTOs (`dto/`)
- `request/`
  - `LoanRequestDTO.java` - Loan application request
  - `SubscriptionRequestDTO.java` - Subscription request
- `response/`
  - `LoanResponseDTO.java` - Loan response 
  - `LoanStatusResponseDTO.java` - Loan status response
  - `TransactionResponseDTO.java` - Transaction data response

### Exceptions (`exception/`)
- `CustomerNotFoundException.java` - When customer doesn't exist
- `GlobalExceptionHandler.java` - Central exception handling
- `LoanApplicationException.java` - Loan processing errors
- `ScoringServiceException.java` - Scoring service errors
- `SoapClientException.java` - SOAP client errors

### Lambda Handlers (`lambda/`)
- `BaseLambdaHandler.java` - Base class for Lambda handlers
- `CustomerLoansLambda.java` - Get customer loans handler
- `LoanRequestLambda.java` - Loan request handler
- `LoanStatusLambda.java` - Loan status handler
- `RefreshTransactionsLambda.java` - Refresh transactions handler
- `ScoringProcessorLambda.java` - Processing scoring handler
- `SubscriptionLambda.java` - Subscription handler
- `TransactionDataLambda.java` - Transaction data handler

### Domain Models (`model/`)
- `Customer.java` - Customer entity
- `Loan.java` - Loan entity
- `LoanStatus.java` - Loan status enum
- `ScoringResult.java` - Scoring result model
- `Transaction.java` - Transaction entity

### Repositories (`repository/`)
- `CustomerRepository.java` - Customer data access
- `LoanRepository.java` - Loan data access
- `TransactionRepository.java` - Transaction data access

### Services (`service/`)
- `customer/`
  - `CustomerService.java` - Interface
  - `CustomerServiceImpl.java` - Implementation
- `loan/`
  - `LoanService.java` - Interface
  - `LoanServiceImpl.java` - Implementation
- `scoring/`
  - `ScoringService.java` - Interface
  - `ScoringServiceImpl.java` - Implementation
- `transaction/`
  - `TransactionService.java` - Interface
  - `TransactionServiceImpl.java` - Implementation

### Clients (`client/`)
- `soap/`
  - `KycClient.java` - KYC SOAP client
  - `TransactionClient.java` - Transaction SOAP client
- `rest/`
  - `ScoringEngineClient.java` - Scoring engine REST client

### Messaging (`messaging/`)
- `MqttConfig.java` - MQTT configuration
- `MqttService.java` - MQTT service
- `SqsConfig.java` - SQS configuration
- `SqsMessageReceiver.java` - SQS message consumer
- `SqsMessageSender.java` - SQS message producer

### Utilities (`util/`)
- `RetryUtil.java` - Retry mechanism utilities
- `SecurityUtil.java` - Security utilities

## Resources


```css
resources/
├── application.yml            # Base configuration
├── application-dev.yml        # Development configuration
├── application-prod.yml       # Production configuration
├── application-aws.yml        # AWS configuration
└── wsdl/                      # WSDL files
├── customerWsdl.wsdl      # KYC WSDL
└── transactionWsdl.wsdl   # Transaction WSDL
```

## Test Structure

```css
test/
├── java/                      # Test classes
│   └── com/credable/lms/
│       ├── controller/        # Controller tests
│       ├── service/           # Service tests
│       ├── client/            # Client tests
│       └── lambda/            # Lambda handler tests
└── resources/                 # Test resources
├── application-test.yml   # Test configuration
└── mockdata/              # Test data
```

## AWS Deployment Resources

```css
aws/
├── template.yaml              # SAM template
├── cfn/                       # CloudFormation templates
│   ├── api-gateway.yaml
│   ├── lambda-functions.yaml
│   ├── dynamodb-tables.yaml
│   └── sqs-queues.yaml
└── scripts/
├── deploy.sh              # Deployment script
└── test-api.sh            # API testing script
```

## Documentation

```css
docs/
├── api-documentation.md       # API reference
├── aws-sam-deployment-guide.md # AWS deployment guide
├── requirements-audit.md      # Requirements verification
├── integration-test-plan.md   # Testing strategy
├── project-setup-guide.md     # Setup instructions
├── quick-start-guide.md       # Quick start guide
├── architecture-diagram.png   # Architecture diagram
├── sequence-diagrams/         # Flow diagrams
└── postman/                   # Postman collection
```
