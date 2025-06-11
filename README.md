# QR Code Generator

A Spring Boot application for generating QR codes from text or URLs. This application provides a simple REST API to generate QR codes with customizable parameters.

## Features

- Generate QR codes from text or URLs
- Customizable QR code size and format
- Simple REST API integration
- Docker support for easy deployment
- Environment-based configuration

## Prerequisites

- Java 17 or higher
- Maven 3.6.3 or higher
- Docker (optional, for containerized deployment)

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/qrcode-generator.git
cd qrcode-generator
```

### 2. Build the Application

```bash
mvn clean install
```

### 3. Run the Application

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080` by default.

## API Endpoints

### Generate QR Code

```
POST /api/qrcode/generate
```

**Request Body:**
```json
{
    "text": "https://example.com",
    "width": 250,
    "height": 250
}
```

**Response:**
- Success: Returns the generated QR code image
- Error: Returns appropriate error message

## Configuration

Edit the `application.properties` file to configure application settings:

```properties
# Server configuration
server.port=8080

# QR Code defaults
qrcode.default.width=200
qrcode.default.height=200
```

## Docker Support

Build and run the application using Docker:

```bash
# Build the Docker image
docker build -t qrcode-generator .

# Run the container
docker run -p 8080:8080 qrcode-generator
```

## Environment Variables

Create a `.env` file in the root directory with the following variables:

```
# AWS Configuration
AWS_REGION=your-aws-region
AWS_BUCKET_NAME=your-s3-bucket-name

# Server Configuration
SERVER_PORT=8080

# Application Configuration
SPRING_APPLICATION_NAME=qrcode.generator
```

**Note:** The `.env` file is included in `.gitignore` for security reasons. Make sure to set up these environment variables in your deployment environment.

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Built with Spring Boot
- QR Code generation powered by ZXing library
- Docker support for containerization