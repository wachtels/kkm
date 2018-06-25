package org.hfu.kkm.test;

import org.junit.Test;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "org.hfu.kkm")
public class ArchUnitTest {
	
	/*@Test
	public void Services_should_only_be_accessed_by_Controllers() {
	    JavaClasses classes = new ClassFileImporter().importPackages("org.hfu.kkm");

	    ArchRule myRule = classes()
	        .that().resideInAPackage("..service..")
	        .should().onlyBeAccessed().byAnyPackage("..controller..", "..service..");

	    myRule.check(classes);
	}*/
	
	@ArchTest
    public static final ArchRule myRule = classes()
        .that().resideInAPackage("..service..")
        .should().onlyBeAccessed().byAnyPackage("..controller..", "..service..");
}
