## Contributing
To contribute you simply have to build the workspace

To build this workspace:
1. Fork this repository
* run `gradlew setupDecompWorkspace`
* Prepare your preferred IDE
  * You can either install a Gradle plugin for your IDE (if it has any) and point to build.gradle or you can run `gradlew.bat setupDecompWorkspace` and import this folder as an archive
* Start developing

#### Code Guidelines
- Use Hard Tabs (not spaces)
- Minimize Wrapping
- No Comment Wrapping
- Indent once for each block level
- Constants must be UPPERCASED
- For one line if statements, omit brackets ('{' and '}')
- Documented code is highly recommended (high use code must be documented)
- For heavy Battlegear 2 manipulation, use the bg2 package
- Removal of public or protected methods and classes is now forbidden until major version bump. Deprecate only. See [Semantic Versioning](http://semver.org) (All semver is temporarily inactive until the api is up)
- It is suggested to mark probable changes between upcomming MC versions

#### Issue Submission Guidelines
- Use [pastebin](http://pastebin.com), [gist](https://gist.github.com/), or another paste site for logs (DON'T SUBMIT LOGS DIRECTLY INTO ISSUE)
- Name your issue descriptively (like "Hitting dragon with shield crashes", not "Help" or "Dragon crash")
- In the issue body, describe your problem and provide a link to the log (if available)
- Describe how to replicate the issue (descretion is expected)
- (For crashes) No logs, no help
