# -*- mode: ruby -*-
# vi: set ft=ruby :

ENV['VAGRANT_DEFAULT_PROVIDER'] = 'docker'

Vagrant.configure(2) do |config|

    def load_vagrant_config()
      require 'yaml'
      vagrant_config = {"start-web" => "true"}
      begin
    	  vagrant_config = YAML.load_file("./vagrant_config.yml")
      rescue
          puts "./vagrant_config.yml not available. Resorting to defaults"
      end
      vagrant_config
    end

    vagrant_config = load_vagrant_config()

    # port forward syntax ["host_machine":"vm"]
    config.vm.define "db" do |db|
      db.vm.provider "docker" do |d|
        d.image = "postgres:9.4"
        d.name = "postgres"
        d.ports = ["5432:5432"]
        d.env = {"POSTGRES_PASSWORD" => "postgres"}
        d.vagrant_vagrantfile = "./DockerHostVagrantfile"
      end
    end

    if vagrant_config["start-web"] == "true"
      config.vm.define "web" do |web|
        web.vm.provider "docker" do |d|
          d.build_dir = "."
          d.link("postgres:postgres")
          d.ports = ["8080:8080"]
          d.vagrant_vagrantfile = "./DockerHostVagrantfile"
        end
      end
    end
end
