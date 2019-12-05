javac -d outDir --module-source-path my-modules^
 my-modules/module.one/com/github/lazyf1sh/modules/one/ClassModuleOne.java^
 my-modules/module.two/com/github/lazyf1sh/modules/two/ModuleTwoClass.java

@PAUSE

rem --module-source-path option (used above) is specific to multi-module mode which specifies the main source directory for multiple modules.
rem ^ just lets you continue to write a command in the next line

rem -d directory
rem  Set the destination directory for class files. The directory must already exist; javac will not create it. If a class is part of a package, javac puts the class file in a subdirectory reflecting the package name, creating directories as needed. For example, if you specify -d C:\myclasses and the class is called com.mypackage.MyClass, then the class file is called C:\myclasses\com\mypackage\MyClass.class.
rem  If -d is not specified, javac puts each class files in the same directory as the source file from which it was generated.
rem
rem  Note: The directory specified by -d is not automatically added to your user class path.