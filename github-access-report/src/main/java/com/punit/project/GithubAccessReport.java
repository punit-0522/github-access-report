package com.punit.project;

import org.kohsuke.github.*;
import java.io.IOException;

public class GithubAccessReport {

    public static void main(String[] args) throws IOException {

        String token = System.getenv("GITHUB_TOKEN");
        String repositoryName = "punit-0522/github-access-report";

        GitHub github = new GitHubBuilder().withOAuthToken(token).build();

        GHRepository repository = github.getRepository(repositoryName);

        System.out.println("GitHub Repository Access Report");
        System.out.println("--------------------------------");

        for (GHUser user : repository.getCollaborators()) {

            GHPermissionType permission = repository.getPermission(user);

            System.out.println("User: " + user.getLogin() + " | Permission: " + permission);
        }
    }
}