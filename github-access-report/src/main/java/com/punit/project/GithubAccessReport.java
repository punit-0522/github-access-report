package com.punit.project;

import org.kohsuke.github.*;
import java.io.IOException;
import java.util.Map;

public class GithubAccessReport {

    public static void main(String[] args) {

        try {

            // Read GitHub token from environment variable
            String token = System.getenv("GITHUB_TOKEN");

            if (token == null || token.isEmpty()) {
                System.out.println("ERROR: GITHUB_TOKEN environment variable not set.");
                System.out.println("Set it in PowerShell like this:");
                System.out.println("$env:GITHUB_TOKEN=\"your_token_here\"");
                return;
            }

            // Connect to GitHub
            GitHub github = new GitHubBuilder()
                    .withOAuthToken(token)
                    .build();

            // Get authenticated user
            GHMyself me = github.getMyself();

            System.out.println("======================================");
            System.out.println(" GitHub Repository Access Report ");
            System.out.println("======================================");

            // Fetch repositories
            Map<String, GHRepository> repositories = me.getRepositories();

            if (repositories.isEmpty()) {
                System.out.println("No repositories found.");
                return;
            }

            // Loop through repositories
            for (GHRepository repo : repositories.values()) {

                System.out.println("\nRepository: " + repo.getName());
                System.out.println("--------------------------------");

                // List collaborators
                for (GHUser user : repo.getCollaborators()) {

                    GHPermissionType permission = repo.getPermission(user);

                    System.out.println(
                            "User: " + user.getLogin() +
                            " | Permission: " + permission
                    );
                }
            }

        } catch (IOException e) {
            System.out.println("Error connecting to GitHub API");
            e.printStackTrace();
        }
    }
}