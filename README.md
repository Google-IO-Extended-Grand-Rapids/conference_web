[![Build Status](https://travis-ci.org/Google-IO-Extended-Grand-Rapids/conference_web.svg?branch=develop)](https://travis-ci.org/Google-IO-Extended-Grand-Rapids/conference_web)
[![Coverage Status](https://coveralls.io/repos/Google-IO-Extended-Grand-Rapids/conference_web/badge.svg?branch=develop)](https://coveralls.io/r/Google-IO-Extended-Grand-Rapids/conference_web?branch=develop)

# Command to run the application locally
vagrant up --no-parallel

# Connecting to the database from host machine
In order to allow this, you must destroy the Vagrant container so the appropriate ports are forwarded
- Host: localhost
- Port: 5432
- username: postgres

# Vagrant Startup
If you do not want to run the web docker container, and instead would prefer to only startup the database container, then please follow the instructions below
- Copy the vagrant_config.yml.template to vagrant_config.yml
- adjust the "start-web" to be false
Now, when you perform the vagrant commands (up, halt), it will only be for the db
