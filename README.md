# OCI Autoscaling Getting Started

## Create stack

We are going to create an Instance Pool and enable Autoscaling.

We are going to add a Load Balancer to dispatch request to the instances evenly.

> TODO terraform script

## Build the App

Under `src` we have a Java application:

`./gradlew shadowJar`

It is going to generate a file `build/libs/prime-factors-0.1-all.jar`

## Stress CPU to autoscale

For creating stress on the system we are going to use [Apache Benchmark](https://httpd.apache.org/docs/2.4/programs/ab.html)

From a Linux instance, install the Apache tools:

`sudo yum update`
`sudo yum install httpd-tools`

Run `ab` with:

`ab -n 50000000 -c 100 http://<loadbalancer_public_ip>:8080/factorization/12345678909`

From docker:

`docker run --rm jordi/ab -n 50000000 -c 100 -v 2 http://<loadbalancer_public_ip>:8080/factorization/12345678909`

VM configuration

```
scp src/prime-factors/build/distributions/prime-factors-0.1.zip opc@<public-ip>:/home/opc
ssh opc@<public-ip>
sudo yum update -y
sudo yum install jdk-14 -y
sudo firewall-cmd --zone=public --add-port=8080/tcp --permanent
sudo firewall-cmd --reload
unzip prime-factors-0.1.zip
nohup ./prime-factors-0.1/bin/prime-factors > prime-factors.log 2>&1 &
```
