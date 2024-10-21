# Simple Calculator
## Project Overview
This is a Spring Boot backend API for a Calculator application. The API provides endpoints for:
- adding two numbers. /add/{num1}/{num2}
- subtracting one number from another. /subtract/{num1}/{num2}
- multiplying two numbers. /multiply/{num1}/{num2}
- divide one number by another. /divide/{num1}/{num2}

The project contains Dockerfile and necessary Kubernetes YAML files to deploy the application on a Kubernetes cluster. Here, I will tell you about both ways to get this app running locally.

## 1. Running the Application using the public Docker image.
### Prerequisites
Before you start, ensure you have the following installed:
- Docker
### Running a container
```bash
docker run -d -p 9090:9090 --name simple-calculator bhardwajnkl/simple-calculator:1.0
```
Now, Once run you can access the application: http://localhost:9090
Use the 4 endpoints(mentioned in project overview section) for your calculations.

### Clean up
First find the ID of this container using the below command:
```bash
docker ps
```
Now stop and delete the container
```bash
docker stop <CONTAINER_ID>
docker rm <CONTAINER_ID>
```
And finally, remove the image as well:
```bash
docker rmi bhardwajnkl/simple-calculator:1.0
```

## 2. Kubernetes Deployment
### Prerequisites
Before you start, ensure you have the following installed:
- Minikube
- Kubectl

Now, Follow the below steps:
### Step 1: Clone the repository
```bash
git clone https://github.com/BhardwajNkl/simple-calculator.git
cd simple-calculator
```

### Step 2: Start Minikube
If you have not already started Minikube, use the following command to start.
```bash
minikube start
```

### Step 3: Deploy the Application
Apply the deployment and service configuration files to Kubernetes:
```bash
kubectl apply -f kubernetes_deployment/deployment.yaml
kubectl apply -f kubernetes_deployment/service.yaml
```
This does the following:
- Creates a deployment that uses the public Docker image [bhardwajnkl/simple-calculator:1.0] from Docker Hub.
- Creates a Kubernetes service that exposes the application.

### Step 4: Expose the Service
Minikube doesn't expose services externally by default. So, to access the application from your host machine, you'll need to use minikube tunnel. This will expose the service on your local machine.

Run the following command **(run in a seperate terminal, as the tunnel needs to stay active)**:
```bash
minikube tunnel
```

### Step 5: Access the Application
If you have correctly followed the above steps and deployment is up and service is exposed with tunnel, you can access the simple-calculator via the external IP assigned by Minikube.

To find the external IP, use:
```bash
kubectl get services
```

Look for the EXTERNAL-IP and PORT(s). The external IP should be 127.0.0.1 and port 9090.

Now, you can access the Appliation(supported endpoints are given in the project overview section).
**IF THE PAGE DOES NOT LOAD, PLEASE WAIT FOR 1-2 MINUTE. AND REFRESH.**

### Step 6: Clean UP
To remove the service and deployment when you’re done, run:
```bash
kubectl delete -f kubernetes_deployment/service.yaml
kubectl delete -f kubernetes_deployment/deployment.yaml
```

**Stop the Minikube tunnel by pressing CTRL+C or exit the terminal.**

To stop Minikube, use the below command:
```bash
minikube stop
```
