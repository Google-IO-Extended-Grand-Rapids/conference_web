[![Build Status](https://travis-ci.org/Google-IO-Extended-Grand-Rapids/conference_web.svg?branch=develop)](https://travis-ci.org/Google-IO-Extended-Grand-Rapids/conference_web)
[![Coverage Status](https://coveralls.io/repos/Google-IO-Extended-Grand-Rapids/conference_web/badge.svg?branch=develop)](https://coveralls.io/r/Google-IO-Extended-Grand-Rapids/conference_web?branch=develop)

# Development Environment
* [VirtualBox v4.3.20+](https://www.virtualbox.org/wiki/Downloads)
* [Vagrant v1.7.2+](https://www.vagrantup.com/downloads.html)
* Git

# Commands to run the application locally
This will stand up a vagrant docker host and build/start the 2 docker containers needed to run the app.

```
$ git clone git@github.com:Google-IO-Extended-Grand-Rapids/conference_web.git
$ cd conference_web
$ vagrant up --no-parallel
```

# Connecting to the database from host machine
In order to allow this, you must destroy the Vagrant container so the appropriate ports are forwarded
- Host: localhost
- Port: 5432
- username: postgres

# Vagrant Startup
If you do not want to run the web docker container, and instead would prefer to only startup the database container, then please follow the instructions below
After making these modifications, when you perform the vagrant commands (up, halt), it will only be for the db
- Copy the vagrant_config.yml.template to vagrant_config.yml
- adjust the "start-web" to be false
- Start the application using the application-no-web.properties file so it will point to the appropriate postgres machine locally.

# Database commands
Here is a list of database commands that can be ran as maven
## Rollback

```
$ mvn liquibase:rollback -Dliquibase.rollbackCount=1
```

# Command to do a maven build of the webapp after vagrant/docker is setup
By default, install is being used by our DockerFile during build.  Right now it's rigged to point at a specific IP address in the vagrant machine, which isn't ideal.  But hey, it works for now.

To run stuff locally and hit the postgres container in vagrant, use the 'travis' profile that has a config setup to hit localhost.

```
$ mvn clean install -Ptravis
```
