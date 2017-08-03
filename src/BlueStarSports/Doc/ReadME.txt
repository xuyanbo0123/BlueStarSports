I am recently working on Java.
I receive the coding test email this morning and build this project using java in hurry.
I have an appointment on 2:00 PM and will keep working on this project if I have extra time.

/**About the naming convention
 * Different companies have diverse naming convention.
 * Some companies use mXXX to represent class member, iXXX to represent the input value of class method,
 * and xxx to represent local variable.
 * In this project, I simply used xxx to demonstrate this small practice.
 * If I am fortunate to join Blue Star Sports, I will definitely follow your naming convention.
 */

/**About the league requirements
 * Now the requirements by league and company are Hard Coded in PlayerData.
 * In actual practice or later time, these parameters should be stored in files or database so that we can avoid to
 * rebuild and redeploy the whole project.
 */

/**About the architect
 * Now the models, docs, data, tests are packaged in BlueStarSports.
 * In actual practice or later time, the project should be reconstructed to mature architect like Maven so that
 * everything is a more proper location.
 */

/**About the test
 * Now the test contains normal case and max-capacity case.
 * What should happen:
 * 1. if the roster exceed the max attribute allowed by league?
 * 2. if the roster size is negative?
 * There are several ways to solve the above problem. But we need a discussion with our clients to determine
 * which way is better based on the practical situation:
 * 1. this app is internal-used or external-used?
 * 2. the users want us to handle accidents or want them get properly notified.
 * 3. And so on...
 */