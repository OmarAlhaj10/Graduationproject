# Use Case Definitions for Online Coaching System

This document outlines the use cases for the Online Coaching System, derived from the provided UML Use Case Diagram and supplementary user information.

## Actors

*   **User:** The most general actor, representing any individual interacting with the system. Both Trainees and Coaches are specialized types of Users.
*   **Trainee:** A specialized user who seeks fitness guidance, programs, and community engagement. Trainees interact with coaches, follow training programs, and participate in the platform’s community.
*   **Coach:** A specialized user who provides training programs, manages trainees, and contributes to the community.

## Use Cases

### 1. Login
*   **Description:** Allows a registered User (Trainee or Coach) to gain access to the Online Coaching System by providing valid credentials.
*   **Actors:** User

### 2. View Community Page
*   **Description:** Enables a User to access and browse the community forum, where they can view posts shared by other users.
*   **Actors:** User, Trainee

### 3. View Home Page
*   **Description:** Allows a User to view their personalized home page. For Trainees, this includes exploring system features and viewing coach's programs. For Coaches, this includes checking subscribed trainees and managing programs.
*   **Actors:** User, Trainee, Coach

### 6. Upload Posts
*   **Description:** Enables a User (Trainee or Coach) to create and publish content to the community page.
*   **Actors:** User (Trainee, Coach)


### 8. Subscribe to Coach
*   **Description:** Allows a Trainee to subscribe to a Coach's services, which includes the creation of a personalized diet and exercise plan.
*   **Actors:** Trainee
*   **Includes:** Create Diet & Exercise by (coach / AI)

### 9. Create Diet & Exercise by (coach / AI)
*   **Description:** This is an included use case of 'Subscribe to Coach'. It involves either the Coach or an AI system generating a personalized diet and exercise plan for the Trainee.
*   **Actors:** Coach, AI (system)


### 11. View & Update Progress
*   **Description:** Enables a Trainee to view their current progress and update their records within the system.
*   **Actors:** Trainee

### 12. View Assigned Trainees
*   **Description:** Allows a Coach to view a list of all Trainees assigned to them.
*   **Actors:** Coach
*   **Includes:** Modify Training Program

### 13. Modify Training Program
*   **Description:** This is an included use case of 'View Assigned Trainees'. It allows a Coach to adjust or update the training program for an assigned Trainee.
*   **Actors:** Coach




## Detailed Use Case Descriptions

### Use Case: Login
*   **Actors:** User (Trainee, Coach)
*   **Preconditions:** The User has an account in the Online Coaching System.
*   **Postconditions:** The User is successfully logged in and redirected to their respective home page (Trainee Home Page or Coach Home Page).
*   **Main Flow:**
    1.  The User navigates to the login page.
    2.  The System displays the login form, requesting username/email and password.
    3.  The User enters their credentials and submits the form.
    4.  The System validates the credentials.
    5.  If credentials are valid, the System logs in the User and redirects them to their home page.
*   **Alternative Flows:**
    *   **Invalid Credentials:** If credentials are invalid, the System displays an error message and prompts the User to try again.
    *   **Account Locked:** If the account is locked due to multiple failed attempts, the System informs the User and provides instructions for unlocking.

### Use Case: View Community Page
*   **Actors:** User (Trainee, Coach)
*   **Preconditions:** The User is logged into the system.
*   **Postconditions:** The User can view all posts on the community page.
*   **Main Flow:**
    1.  The User navigates to the Community Page.
    2.  The System displays all public posts, ordered by recency.
    3.  The User can scroll through the posts and view their content.

### Use Case: View Home Page
*   **Actors:** User (Trainee, Coach)
*   **Preconditions:** The User is logged into the system.
*   **Postconditions:** The User is presented with their personalized home page, displaying relevant information based on their role.
*   **Main Flow (Trainee):**
    1.  The Trainee logs in or navigates to the Home Page.
    2.  The System displays the Trainee's personalized dashboard, including progress overview, subscribed coach information, and recommended programs.
    3.  The Trainee can view their current status and access quick links.
*   **Main Flow (Coach):**
    1.  The Coach logs in or navigates to the Home Page.
    2.  The System displays the Coach's personalized dashboard, including a list of assigned trainees, program management tools, and recent activities.
    3.  The Coach can manage their trainees and programs from this page.


### Use Case: Upload Posts
*   **Actors:** User (Trainee, Coach)
*   **Preconditions:** The User is logged into the system.
*   **Postconditions:** The User's post is successfully published on the community page.
*   **Main Flow:**
    1.  The User navigates to the 


Upload Post section or initiates a new post from the Community Page.
    2.  The System provides an interface for creating a new post (e.g., text editor, image/video upload options).
    3.  The User composes their post, adding text, images, or videos as desired.
    4.  The User submits the post.
    5.  The System processes the post and publishes it to the Community Page.
*   **Alternative Flows:**
    *   **Content Moderation:** If the post contains inappropriate content, the System may flag it for review or prevent its publication.

### Use Case: Subscribe to Coach
*   **Actors:** Trainee
*   **Preconditions:** The Trainee is logged in and has selected a Coach to subscribe to.
*   **Postconditions:** The Trainee is subscribed to the Coach, and a diet and exercise plan is created.
*   **Main Flow:**
    1.  The Trainee selects a Coach to subscribe to.
    2.  The System presents subscription details and confirmation.
    3.  The Trainee confirms the subscription.
    4.  The System initiates the 'Create Diet & Exercise by (coach / AI)' use case.
    5.  The System confirms the successful subscription to the Trainee.

### Use Case: Create Diet & Exercise by (coach / AI)
*   **Actors:** Coach, AI (system)
*   **Preconditions:** A Trainee has subscribed to a Coach.
*   **Postconditions:** A personalized diet and exercise plan is generated and assigned to the Trainee.
*   **Main Flow (Coach):**
    1.  Upon Trainee subscription, the Coach is notified.
    2.  The Coach accesses the Trainee's profile and requirements.
    3.  The Coach designs and inputs the diet and exercise plan into the system.
    4.  The System saves and assigns the plan to the Trainee.
*   **Main Flow (AI):**
    1.  Upon Trainee subscription, the System (AI) automatically gathers Trainee data (e.g., goals, preferences, health data).
    2.  The AI generates a personalized diet and exercise plan based on the collected data.
    3.  The System assigns the plan to the Trainee.

### Use Case: View & Update Progress
*   **Actors:** Trainee
*   **Preconditions:** The Trainee is logged in and has an assigned diet and exercise plan.
*   **Postconditions:** The Trainee's progress is updated and reflected in their profile.
*   **Main Flow:**
    1.  The Trainee navigates to the 'Progress' section.
    2.  The System displays the Trainee's current progress (e.g., weight, workout completion, diet adherence).
    3.  The Trainee inputs new progress data (e.g., updated weight, completed workout sessions).
    4.  The Trainee saves the updates.
    5.  The System records the new progress data and updates relevant charts/metrics.

### Use Case: View Assigned Trainees
*   **Actors:** Coach
*   **Preconditions:** The Coach is logged in.
*   **Postconditions:** The Coach can view a list of all Trainees subscribed to them.
*   **Main Flow:**
    1.  The Coach navigates to the 'My Trainees' or 'Assigned Trainees' section.
    2.  The System displays a list of all Trainees currently subscribed to the Coach.
    3.  The Coach can select a Trainee from the list to view their details or modify their program.
    4.  The System initiates the 'Modify Training Program' use case upon selection.

### Use Case: Modify Training Program
*   **Actors:** Coach
*   **Preconditions:** The Coach is viewing an assigned Trainee's profile.
*   **Postconditions:** The Trainee's training program is updated with the Coach's modifications.
*   **Main Flow:**
    1.  The Coach selects a Trainee from their assigned list.
    2.  The System displays the Trainee's current training program.
    3.  The Coach makes necessary adjustments to the program (e.g., exercise changes, diet modifications, schedule updates).
    4.  The Coach saves the modified program.
    5.  The System updates the Trainee's program and notifies the Trainee of the changes.




## Use Case Scenarios

### Use Case: Login

#### Scenario 1: Successful Login (Trainee)
*   **Preconditions:** Trainee 'John Doe' has a registered account with username 'john.doe' and password 'password123'.
*   **Steps:**
    1.  John Doe navigates to the Online Coaching System login page.
    2.  He enters 'john.doe' in the username field and 'password123' in the password field.
    3.  He clicks the 'Login' button.
*   **Expected Outcome:** John Doe is successfully logged in and redirected to his Trainee Home Page.

#### Scenario 2: Successful Login (Coach)
*   **Preconditions:** Coach 'Jane Smith' has a registered account with username 'jane.smith' and password 'coachpass'.
*   **Steps:**
    1.  Jane Smith navigates to the Online Coaching System login page.
    2.  She enters 'jane.smith' in the username field and 'coachpass' in the password field.
    3.  She clicks the 'Login' button.
*   **Expected Outcome:** Jane Smith is successfully logged in and redirected to her Coach Home Page.

#### Scenario 3: Failed Login - Invalid Credentials
*   **Preconditions:** User attempts to log in with incorrect credentials.
*   **Steps:**
    1.  A User navigates to the login page.
    2.  They enter 'wronguser' in the username field and 'wrongpass' in the password field.
    3.  They click the 'Login' button.
*   **Expected Outcome:** The System displays an error message: "Invalid username or password. Please try again." The User remains on the login page.

#### Scenario 4: Failed Login - Account Locked
*   **Preconditions:** User 'john.doe' has attempted to log in 5 times with incorrect passwords, leading to account lock.
*   **Steps:**
    1.  John Doe navigates to the login page.
    2.  He enters 'john.doe' and an incorrect password.
    3.  He clicks the 'Login' button.
*   **Expected Outcome:** The System displays an error message: "Your account has been locked due to multiple failed login attempts. Please contact support or use the 'Forgot Password' link to unlock your account." The User remains on the login page.

### Use Case: View Community Page

#### Scenario 1: Successfully View Community Page
*   **Preconditions:** A User is logged in.
*   **Steps:**
    1.  The User clicks on the 'Community' link in the navigation bar.
*   **Expected Outcome:** The Community Page loads, displaying a list of public posts, ordered by recency. The User can scroll through and view the content of the posts.

### Use Case: View Home Page

#### Scenario 1: Trainee Views Home Page
*   **Preconditions:** Trainee 'John Doe' is logged in.
*   **Steps:**
    1.  John Doe is redirected to the Home Page after successful login, or clicks the 'Home' link.
*   **Expected Outcome:** The Trainee Home Page displays John Doe's personalized dashboard, including his progress overview, information about his subscribed coach, and recommended programs. Quick links to other sections are also visible.

#### Scenario 2: Coach Views Home Page
*   **Preconditions:** Coach 'Jane Smith' is logged in.
*   **Steps:**
    1.  Jane Smith is redirected to the Home Page after successful login, or clicks the 'Home' link.
*   **Expected Outcome:** The Coach Home Page displays Jane Smith's personalized dashboard, including a list of her assigned trainees, program management tools, and recent activities. She can access tools to manage her trainees and programs.

### Use Case: Upload Posts

#### Scenario 1: Successful Post Upload (Trainee)
*   **Preconditions:** Trainee 'John Doe' is logged in.
*   **Steps:**
    1.  John Doe navigates to the Community Page and clicks 'Create New Post'.
    2.  He types a message: "Just finished my workout, feeling great!" and attaches a photo.
    3.  He clicks 'Publish'.
*   **Expected Outcome:** The post is successfully published on the Community Page, visible to other users. A confirmation message is displayed.

#### Scenario 2: Successful Post Upload (Coach)
*   **Preconditions:** Coach 'Jane Smith' is logged in.
*   **Steps:**
    1.  Jane Smith navigates to the Community Page and clicks 'Create New Post'.
    2.  She types a message: "Here are some tips for staying motivated!" and includes a link to an article.
    3.  She clicks 'Publish'.
*   **Expected Outcome:** The post is successfully published on the Community Page, visible to other users. A confirmation message is displayed.

#### Scenario 3: Failed Post Upload - Content Moderation
*   **Preconditions:** A User attempts to upload a post with inappropriate content.
*   **Steps:**
    1.  A User attempts to create a new post.
    2.  They type a message containing offensive language.
    3.  They click 'Publish'.
*   **Expected Outcome:** The System prevents the post from being published and displays a message: "Your post contains inappropriate content and cannot be published." The User is prompted to revise the content.

### Use Case: Subscribe to Coach

#### Scenario 1: Successful Subscription
*   **Preconditions:** Trainee 'John Doe' is logged in and views Coach 'Jane Smith's profile.
*   **Steps:**
    1.  John Doe clicks 'Subscribe to Coach' on Jane Smith's profile.
    2.  He reviews the subscription details and clicks 'Confirm Subscription'.
*   **Expected Outcome:** John Doe is successfully subscribed to Jane Smith. The system initiates the 'Create Diet & Exercise by (coach / AI)' use case, and John Doe receives a confirmation message.

### Use Case: Create Diet & Exercise by (coach / AI)

#### Scenario 1: Coach Creates Plan
*   **Preconditions:** Trainee 'John Doe' has subscribed to Coach 'Jane Smith'.
*   **Steps:**
    1.  Jane Smith receives a notification about John Doe's new subscription.
    2.  She accesses John Doe's profile and reviews his goals and preferences.
    3.  She designs a personalized diet and exercise plan and inputs it into the system.
    4.  She saves the plan.
*   **Expected Outcome:** A personalized diet and exercise plan is created by Jane Smith and assigned to John Doe. John Doe is notified of his new plan.

#### Scenario 2: AI Creates Plan
*   **Preconditions:** Trainee 'Emily White' has subscribed to a Coach, and the system is configured for AI-generated plans.
*   **Steps:**
    1.  Upon Emily White's subscription, the System (AI) automatically collects her data (e.g., age, weight, fitness level, dietary restrictions).
    2.  The AI processes this data and generates a personalized diet and exercise plan.
    3.  The System assigns the plan to Emily White.
*   **Expected Outcome:** A personalized diet and exercise plan is automatically generated by the AI and assigned to Emily White. Emily White is notified of her new plan.

### Use Case: View Assigned Trainees

#### Scenario 1: Successfully View Assigned Trainees
*   **Preconditions:** Coach 'Jane Smith' is logged in.
*   **Steps:**
    1.  Jane Smith clicks on 'My Trainees' from her Coach Home Page.
*   **Expected Outcome:** A list of all Trainees currently subscribed to Jane Smith is displayed. Each Trainee's name and basic information are visible. Jane Smith can select a Trainee to view their details or modify their program.

### Use Case: Modify Training Program

#### Scenario 1: Successfully Modify Training Program
*   **Preconditions:** Coach 'Jane Smith' is viewing Trainee 'John Doe's profile.
*   **Steps:**
    1.  Jane Smith selects John Doe from her 'My Trainees' list.
    2.  She navigates to John Doe's training program.
    3.  She changes a specific exercise from 'push-ups' to 'bench press' and updates the repetitions.
    4.  She clicks 'Save Program'.
*   **Expected Outcome:** John Doe's training program is updated with the new exercise and repetitions. John Doe receives a notification about the program change. A confirmation message is displayed to Jane Smith.


