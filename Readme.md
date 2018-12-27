# Mid Day Farmer 2018 - Documentation

### Creating an Internal Library
	1. Create a new Module in “Project Structure”
	2. Name the module, and ensure “Content Root” is pointing inside the “MDF-Libs” folder & ensure your module is in its own folder.
		* Example: “MidDayFarmer_2018/MDF-Libs/Debugger” would be the “Content Root” for a “Debugger” module.
	3. Add your base class as an “Artifact” inside “Project Structure” ensuring the output directory is the the “Libs” folder & “Module” is set to the appropriate module, not “<All Modules>”.
		* You will need a “Public static void main” inside your primary class for the Library.
	4. Check “Include in Project Build” inside the newly created “Artifact”.
	5. Run build, and import the newly created library into your necessary Modules.
	
### Importing an Internal Library
    1. Inside "Project Structure" press "Add" in "Libraries" and select "Java".
    2. Navigate to the "Libs" folder inside project folder.
    3. Select the appropriate Jar for the compiled Library.
    4. Select which modules this Library will be necessary in.

## Server Specific
    
### To Create a Config Item
All configuration must be handled inside the "ConfigManager.java" file.
This is HOPEFULLY temporary until a better solution is found.
 
    1. At the bottom of "ConfigManager" inside the "mdfServerCfg" class
    2. Add the variable you would like to manage and maintain. This MUST be public!
    3. Pass this element to the constructor.
    4. Inside "createConfig" add the default value for the new option.
    5. Inside "parseConfig" add the default behavior for the config option.
    6. You MUST re-generate the config file. Without doing so will cause your setting to not appear.
    
To note. If a config item is found to need multiple items, you must create an entire class and
use that as what is passed around.