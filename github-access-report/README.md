# GitHub Repository Access Report

This Java application connects to the GitHub API and generates a report showing user access permissions for a repository.

## Technologies

* Java
* Maven
* GitHub API (org.kohsuke.github)

## Features

* Authenticate using GitHub Personal Access Token
* Fetch repository collaborator permissions
* Display access levels (ADMIN, WRITE, READ)

## Build

mvn clean package

## Run

java -cp "target/classes;target/dependency/*" com.punit.project.GithubAccessReport

## Example Output

## GitHub Repository Access Report

User: punit-0522 | Permission: ADMIN
