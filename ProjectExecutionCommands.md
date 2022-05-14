# Project Execution Steps

## MySQl
  * Open MySQL Workbench
  * Open the localhost connection
  * Open Database.md
  * Copy the complete scripts to MySQL Workbench
  * Execute all the ddl & dml commands
  * Refere CMS_SchemaDiagram.png file to add remaining tables in CMS project

## Java
  * Open Gitbash with the following path
  * `cd /CanteenManagementSystem`
  * `mvn compile`
  * `mvn exec:java -Dexec.mainClass=com.Hexaware.CMS.Cli.CliMain`
    * As expected, the cli displays the MENU; 
    * Menu and Place order functionalities are implemented and can be executed  
      [Place order is executed with partial attribute, add remaining attributes and complete it]   
  * Refere CMS_Requirement.md to add other functionalities
  * Refere CMS_ScreenDesign folder to build complete project
  * Complete all Must-to-have features from CMS_Requirement.md file. Nice-to-have and Great-to-have features is additional task.
  


## Unit Testing
  * The following command will execute the test cases created in the test class,
  *   `mvn test`
  * Write the corresponding test cases for all the methods in the CMS project.