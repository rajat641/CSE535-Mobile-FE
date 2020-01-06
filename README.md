# CSE535FinalProject - MathMates App
An Android application that aims to conduct research on group formation for problem-solving collaboration: do
similar preferences of users affect performance? The application allows users to match with other users to solve math problems together in order to measure similarity
levels and see if there’s a correlation between collaboration and comfortability levels.

## PROJECT SETUP & PERMISSIONS
The architecture consists of 3 systems. The configurations
and functions are described below:
1. Android device:
    Make & Model: OnePlus 6T OS: Oxygen OS
    10.0.1 hotfix
2.  Cloud Server (AWS Elastic Cloud Compute-2):
    OS: Ubuntu 18.01
    Processor: Intel i7 7th generation
    RAM: 16gb DDR5
    Nginx: (Web Server)
3. Database: MySQL
    Instance: Amazon RDS
    Database Vendor- MySQL RDBMS
The android device communicated with the EC2 servers using a bidirectional SSH.

1. The servers use a Django based RESTful web services hosted on Nginx server.
2. We have used Django 2.1 and python 3 for implementation
3. The user data from Mathmates is stored in a MySQL Database hosted at Cloud.
4. The user authentication and user matching logic is written in Django and accessed using REST APIs
by the Android App.
    
### The Detailed report on the project can be found here -
[Group30_Project_Report.pdf](https://github.com/rajat641/CSE535-Mobile-FE/files/4025631/Group30_Project_Report.pdf)
