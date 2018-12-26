# Mid Day Farmer 2018 - Documentation

## Creating an Internal Library
	1. Create a new Module in “Project Structure”
	2. Name the module, and ensure “Content Root” is pointing inside the “MDF-Libs” folder & ensure your module is in its own folder.
		* Example: “MidDayFarmer_2018/MDF-Libs/Debugger” would be the “Content Root” for a “Debugger” module.
	3. Add your base class as an “Artifact” inside “Project Structure” ensuring the output directory is the the “Libs” folder & “Module” is set to the appropriate module, not “<All Modules>”.
		* You will need a “Public static void main” inside your primary class for the Library.
	4. Check “Include in Project Build” inside the newly created “Artifact”.
	5. Run build, and import the newly created library into your necessary Modules.
	
## Importing an Internal Library
    1. Inside "Project Structure" press "Add" in "Libraries" and select "Java".
    2. Navigate to the "Libs" folder inside project folder.
    3. Select the appropriate Jar for the compiled Library.
    4. Select which modules this Library will be necessary in.