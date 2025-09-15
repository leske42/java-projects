I have created these projects at a 2 weeks Java-training at [NIX](https://nixstech.com/) company.

In my experience switching to Java after C++ is quite straightforward & relatively smooth experience. I did not go *very deep* into Java but the basics are quite similar. The setup of the infrastructure necessary for development can be a bit of a challenge at first, but I used IntelliJ IDEA and it proved to be super helpful.

I will make also some little note of all of the theory we have learned.

Since these were originally different tiny repos that I merged into one, I have added a tiny guide on how to do that. (There is of course a simple way of copy and paste, but I wanted to preserve my the commit histories of both of the small repositories).

### How to combine different repos into one (while preserving commit histoy)

First create new repo where you want to combine your projects if you don't have it already.
You can also use one of your existing repos which hosts one of the projects, then you can skip this step.
```
git init <new_repo_name>
cd <new_repo_name>
```
In cases its a brand new repo, you need to have at least a commit on main (or master) to preserve it. So you can add a README for example.

Then you need to add one of the other repos you want to merge as remote. The path can be both local and remote. So could be something like `git@github.com:username/repo.git`, but for me it was simply `../folder-name`.
```
git remote add <alias-for-your-remote> <path-to-your-other-repo>
```
You need to `fetch` all branches from your remote (you don't want to merge yet), and then create a new branch which will have the contents of the `main` branch of your remote (or you can set any other you prefer).
```
git fetch <alias-for-your-remote>
git checkout -b <branch-name> <alias-for-your-remote>/main
```
Now you are on the other branch. If you want to, you can move all of the files here into a sub directory (and naturally commit that change), so in your big final repo, you will know these files belonged to one project originally.

The issue is, this branch now has a completely different commit history than your `main`. So you need to `rebase` it on your `main`. The flag I added is important, otherwise `rebase` will change all of your past commits to look like they were created today.
```
git rebase --committer-date-is-author-date main
```
Solve all of the conflicts that might happen. If you took my strategy with the sub directories, then this is not likely to be an issue.

Now you go back to `main` and merge the repo content from your branch.
```
git switch main
git merge <branch-name>
```
If you have more repos you want to merge, just keep repeating this process until you are done.

