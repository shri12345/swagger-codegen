package com.wordnik.swagger.codegen.config;

/**
 * Implementor of this class is responsible for generating the names for service classes and methods in
 * each of those service classes
 *
 * User: ramesh
 * Date: 5/27/11
 * Time: 7:36 AM
 */
public interface NamingPolicyProvider {

    /**
     * Gets name of the version checker class. We need not provide extension for the class as that will be read
     * through a class extention configuration value.
     *
     * Example: In java this is VersionChecker.
     *
     * @return
     */
    public String getVersionCheckerClassName();


    /**
     * Convert input string into class name format.
     *
     * Example: in java this will be init caps.
     * 
     * @param input
     * @return
     */
    public String applyClassNamingPolicy(String input);

    /**
     * Transform the input string into method naming convention format.
     *
     * Example: In java, the will be Camel case
     *
     * @param input
     * @return
     */
    public String applyMethodNamingPolicy(String input);

    /**
     * Generates the name of service based on resource path.
     *
     * Example: for a resource path of http://beta.wordnik.com/v4/word.json the service name can be WordAPI
     *
     * @param resourcePath
     * @return
     */
    public String getServiceName(String resourcePath);


    /**
     * Generates the name of service methods.
     *
     * Resource documentation provides suggested names. Individual language can choose to use suggested name or
     * generate the name based on end point path. Example: IN java we use suggested name
     *
     * @param endPoint
     * @param suggestedName
     * @return
     */
    public String getMethodName(String endPoint, String suggestedName);


    /**
     * Generate of the input object using the resource path name.
     *
     * When the number of arguments for a method increases beyond certain limit, we want to capture all the arguments
     * as a single input objects so that it is easy for client to understand the API.
     *
     * Example: get examples API on words resource takes inputs as : word, limit, include duplicates, content provider,
     * use canonical, skip, limit. Instead of having all these as individual arguments create an input object with name
     * WordsExampleInput and have above arguments as properties fo the object.
     *
     * @param serviceName
     * @param resourcePath
     * @return
     */
    public String getInputObjectName(String serviceName, String resourcePath);

    /**
     * Generates a name for an enum for the param or field name.
     *
     * Example: for a param source the return could be SourceEnum
     *
     * @param input
     * @return
     */
    public String getEnumName(String input);

    /**
     * Gets the signature of the method that gets value for give attribute name.
     *
     * Example: If class name is user and attibute name is email the out in java language will be
     *  <code>user.getEmail()</code>
     *
     * @param className
     * @param attributeName
     * @return
     */
    public String createGetterMethodName(String className, String attributeName);
}
