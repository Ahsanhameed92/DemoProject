Question and Answers

1.What is the major difference between an  abstract class and an  interface? 

Abstract class and interface both are used to achieve abstraction the following are the major differences between abstract class and interface
 1-Interface is used to achieve fully abstraction (100%) while abstract class is used to achieve partially  abstraction (0 to 100%).
 2-Abstract class can have abstract and non-abstract methods while Interface can have only abstract methods.
 3-Abstract class doesn't support multiple inheritance while Abstract class doesn't support multiple inheritance.
 4-Abstract class can have final, non-final, static and non-static variables on the other hand abstract class can have final, non-final, static and non-static variables. 
 5-A Java class can implement multiple interfaces but it can extend only one abstract class.
 6-Methods of a Java interface are implicitly abstract and cannot have implementations. A Java abstract class can have instance methods that implements a default behavior.

2.Why is Java 7’s class inheritance flawed?

Can you explain question little bit more? According to my understanding Java does not have multiple inheritance may be this a flaw in class inheritance of java. But Java "solves" multiple inheritance by using interfaces. Java does not have multiple inheritance! This means that Java is not at risk of suffering the consequences of the diamond problem. However, C++ does have multiple inheritance.

3.What are the major differences between  Activities and  Fragments ?
The following are the major differences between activities and fragments.
  1.	An Activity is an application component that provides a screen, with which users can interact in order to do something. Whereas a Fragment represents a behavior or a portion of user interface in an Activity.
  2.	The second major difference is that the Activity can exist independently while Fragment has to live inside the activity. Fragment depends on the lifecycle of a activity.
  3.	The third main difference is that when an activity is placed to the backstack of activities the user can navigate back to the previous activity by just pressing the back button while When an fragment is placed to the activity we have to request the instance to be saved by calling addToBackstack() during the fragment transaction.



4.When using  Fragments , how do you communicate back to their hosting  Activity ? 

We use fragment for flexible and responsive UI when we have to make an application  for different device’s like phone and tablets. Fragments enable both orientations to reuse shared elements while also having differences. Fragments are view controllers they hold decoupled chunks of business logic that can be tested easily .Because fragments are built on top of views and views can easily be animated, fragments would give us better control over screen transitions. Fragment  provides backstack management we can use many fragment with single activity.
To communities with hosting Activity, we have to  define an interface in the Fragment class and implement it within the Activity to receive event callbacks from the fragment.


5.Can you make an entire app without ever using  Fragments ? Why or why not? Are there any special cases when you absolutely have to use or should use Fragments?

Yes we can make an app without using Fragments if there is no complex UI and there is no need to run this app on different devices like phone or tablets or app consist on background functionalities like services etc.
On the other hand there are many special cases where we should use Fragments. Like sometimes It's convenient for the user to see two different views of two different classes on the same screen. For example a listView that takes up half the screen and a webView that takes up the other half - so that when you click on a list item in fragment A it passes an intent to the webView in fragment B, and suddenly you see what you just clicked without the app switching activities - then you could use a fragment. 

6.What makes an  AsyncTask  such an annoyance to Android developers? Detail some of the issues with AsyncTask and how to potentially solve them?

The follwoing are the issues with AsyncTask 
1-When an app is rotated, the entire Activity is destroyed and recreated. When the Activity is restarted, your AsyncTask’s reference to the Activity is invalid, so onPostExecute() will have no effect on the new Activity. The usual solution to this problem is to hold onto a reference to AsyncTask that lasts between configuration changes, which updates the target Activity as it restarts.
2-The other issue with AsyncTask is that if we run AsyncTask in a activity and then finish the Activity the  AsyncTask keep running. The only way that an AsyncTask finishes early is if it is canceled via AsyncTask.cancel().
