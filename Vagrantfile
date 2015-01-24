# -*- mode: ruby -*-
# vi: set ft=ruby :

ENV['VAGRANT_DEFAULT_PROVIDER'] = 'docker'

Vagrant.configure(2) do |config|


    config.vm.define "db" do |db|
      db.vm.provider "docker" do |d|
        d.image = "postgres:9.4"
        d.name = "postgres"
        d.ports = ["5433:5432"]
        d.env = {"POSTGRES_PASSWORD" => "postgres"}
        d.vagrant_vagrantfile = "./DockerHostVagrantfile"
      end
    end
end
