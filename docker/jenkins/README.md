# Jenkins

## Run Docker Compose
````bash
/jenkins

❯ docker-compose up -d
````
Jenkins is running in `localhost:8081`

### First Login
View the generated administrator password to log in the first time.
````bash
❯ docker exec jenkins cat /var/jenkins_home/secrets/initialAdminPassword
````
Now, you're ready to install plugins and start creating pipelines. If you want to stop the Jenkins container you can do it with `docker-compose down`. When you restart it all your configuration, users, plugins previously installed will persist there.

