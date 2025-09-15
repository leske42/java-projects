I have created these projects at a 2 weeks Java-training at [NIX](https://nixstech.com/) company.

In my experience switching to Java after C++ is quite straightforward & relatively smooth experience. I did not go *very deep* into Java but the basics are quite similar. The setup of the infrastructure necessary for development can be a bit of a challenge at first, but I used IntelliJ IDEA and it proved to be super helpful.

I will make also some little note of all of the theory we have learned.

Since these were originally different tiny repos that I merged into one, I have added a tiny guide on how to do that. (There is of course a simple way of copy and paste, but I wanted to preserve my the commit histories of both of the small repositories).

### Specifics of Java language


### OOP Principles

For me it was very good experience that our teachers always said they are more interested in how we structure our code, than specific features of the language. As one can also read in Clean Architecture book, OOP mainly exists to make projects *scalable*. So make it easy to refactor and easy to improve with new features without making everything more and more complicated and harder to follow & maintain.

Most of OOP principles serve this purpose. Java is a good *tool* because by design it makes it really easy to implement these principles in practice, but the importance still lies in the principles and not the language itself (just like I have also used some of these principles in my C++ projects before).

So here is 4 most important principles of OOP:
- **Encapsulation**
    - this principle means you group all of your related data (functions, variables) into a single unit (these are the **objects**). It also means that everything that is only needed for the internal workings of this object (like helper functions) should not be accessible from the outside (see `private`keyword for this).
- **Abstraction**
    - this means when developing a class, we should hide as much of the implementation details as possible. If we have an object `Machine` that performs some calculation, it is best if from the outside we only need to do a simple `Machine.calculate()` instead of instructing it to do all the steps of calculation one by one.
- **Inheritance**
    - inheritance means you have classes that are *based on* other classes (they have all of the data those ones have & more). This also creates a sort of hierarchy between your classes. This one is also called **is-a** relationship: a `Square` *is a* `Rectangle` which *is a* `Shape` (and naturally this means that a `Square` *is also a* `Shape`).
- **Polymorphism**
    - polymorphism takes advantage of inheritance. Very simply put, it's the use of a single symbol to represent multiple different types. This way different objects can be used by the same interface (interface here used in a broad sense). For example you can have a `Dog` or a `Cat` object all accessed through `Animal` interface. This helps a lot with making your code extendable, because if something holds an `Animal` instead of a specific subtype, you can later introduce other animals like `Duck` or `Bat` without needing to refactor already existing code.

Another set of important principles to follow (which can be shortened to **SOLID**):
- **S**ingle Responsibility
    - this sounds the most simple principle but it's the hardest to follow in practice. Requires a lot of design effort. In theory each class should only be responsible for one thing. What qualifies as "one thing" is sometimes a question in practice.
- **O**pen/Closed Principle
    - the code you write should be open for extension, but closed for modification. This means *you should be able to add new behavior without rewriting existing code.* Using the `Animal` interface like I have mentioned earlier is a good example of this.
- **L**iskov Substitution
    - this means objects of a parent class should be replaceable with objects of its sub classes without breaking the program. For example, in C++, since `private` members of a parent class are inaccessible to a sub class, a `private` function in the parent class would miss from the sub class, so it could not be used *as if it was the parent* and thus this principle would be broken (so better to use `protected` keyword but this repo is not about C++).
- **I**nterface Segregation
    - you should have multiple tiny interfaces which each of them a few methods implemented, instead of big monolithic ones. This is because, as it comes from the previous principle, it is not good if a class inherits from an interface but there are some functions it gets that it doesn't end up using in the end. Instead, using **multiple inheritance**, you can opt to inherit from multiple smaller interfaces and pick and choose the functionalities you need.
- **D**ependency Inversion
    - to be honest it's not super clear to me what is the difference between this and just Polymorphism + Open/Close combined. Anyway it means that high-level code should not depend on low-level details, but instead both should rely on abstractions. This makes the system flexible, because the specific low-level parts (like a database for example), so how the exact implementation is done can be swapped without changing the core logic.

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

