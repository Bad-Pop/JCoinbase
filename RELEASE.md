# Releasing

See http://central.sonatype.org/pages/ossrh-guide.html

Sonatype-Nexus specific maven configuration: `~/.m2/settings.xml`

```xml
<settings>
    <servers>
        <server>
            <id>ossrh</id>
            <username>jira-id</username>
            <password>jira-pwd</password>
        </server>
    </servers>
</settings>
```

## Steps to follow
1. **Build project and change version**
```bash
mvn clean install versions:set -DnewVersion=<VERSION>
```
2. **If the build is ok**
```bash
mvn deploy -Dgpg.passphrase="GPG_PASSPHRASE" -Prelease -DskipTests=true
```
3. **Create git a maintenance branch**
```bash
git checkout master
git pull && git fetch
git checkout -b v<RELEASE_VERSION>
git push origin v<RELEASE_VERSION>
```
4. **Generate reports**
```bash
mvn jacoco:prepare-agent clean site jacoco:report
```
