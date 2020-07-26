# Install Docker On Raspberry Pi
## Introduction
Docker is a tool for creating, deploying, and running applications in containers. The software is popular among developers as it speeds up the development process and does not use a lot of resources.

Docker containers are lightweight, especially compared to virtual machines. This feature is especially valuable if you are a Raspberry Pi user.

If you need help installing Docker on your Raspberry Pi, read our step-by-step guide on **how to install Docker on Raspberry Pi**.
## Prerequisites
- Raspberry Pi with a running Raspbian OS
- Raspbian Stretch (Lite)
- SSH connection enable

# How To Install Docker On Raspberry Pi
To install Docker on your Raspberry Pi, you need to go through the following steps:

1. Update and upgrade your system.
2. Download the installation script and install the package.
3. Allow a non-root user to execute Docker commands.
4. Verify installation by checking the Docker version.
5. Test the set up by running a “hello-world” container.
6. Install proper dependencies.
7. Install Docker Compose

## Update and upgrade your system
Start by updating and upgrading the system. This ensures you install the latest version of the software.
Open a terminal window and run the command:
````bash
$ apt-get update && apt-get upgrade
````

## Download the installation script and install the package
Move on to downloading the installation script with:
````bash
$ curl -fsSL https://get.docker.com -o get-docker.sh
````
Execute the script using the command:
````bash
$ sudo sh get-docker.sh
````
This installs the required packages for your Raspbian Linux distribution.
The output will tell you which version of Docker is now running on your system.

## Allow a non-root user to execute Docker commands
By default, only users who have administrative privileges (root users) can run containers. 
If you are not logged in as the root, one option is to use the sudo prefix. However, you could also add your non-root user to the Docker group which will allow it to execute docker commands.

The syntax for adding users to the Docker group is:
```bash
$ sudo usermod -aG docker [user_name]
```

To add the **Pi** user (the default user in Raspbian), use the command:
```bash
$ sudo usermod -aG docker Pi
```

There is no specific output if the process is successful. For the changes to take place, you need to log out and then back in.

## Verify installation by checking the Docker version
Check the version of Docker on your Raspberry Pi by typing:
```bash
$ docker version
```

The output will display the Docker version along with some additional information.
For system-wide information (including the kernel version, number of containers and images, and more extended description) run:
```bash
$ docker info
```

## Test the set up by running a “hello-world” container
The best way to test whether Docker has been set up correctly is to run the Hello World container.
To do so, type in the following command:
```bash
$ docker run hello-world
```

The software will contact the Docker daemon, pull the “hello-world” image, and create a new container based on that image.
Once it goes through all the steps, the output should inform you that **your installation appears to be working correctly**.

<img alt="sf" src="https://github.com/Zeshadowz/tutorials/blob/develop/docker/raspberry-pi-4/img/docker-hello-world-service.png">

## Install proper dependencies
````bash
$ sudo apt-get install -y libffi-dev libssl-dev
$ sudo apt-get install -y python3 python3-pip
$ sudo apt-get remove python-configparser
````

## Install Docker Compose
```bash
$ sudo pip3 -v install docker-compose
```

# How to Upgrade Docker on Raspberry Pi?
There is no need to re-run the convenience script to upgrade Docker. Furthermore, running the convenience script again might cause issues if it attempts to repositories that have been added already.
Upgrade Docker using the package manager with the command:
```bash
$ sudo apt-get upgrade
```

# How to Uninstall Docker on Your Raspberry Pi?
Although you used a convenience script for installation, you can simply remove docker using the package manager:
```bash
$ sudo apt-get purge docker-ce
```
**Note**: Depending on the version of software, you may need to use an additional command to completely remove Docker: **`sudo apt-get purge docker-ce-cli`**.

o delete leftover images, containers, volumes and other related data, run the following command:
```bash
$ sudo rm -rf /var/lib/docker
```
Edited configuration files must be deleted manually.

**Sources**:
- https://phoenixnap.com/kb/docker-on-raspberry-pi
