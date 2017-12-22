package com.graphaware.nlp.classification;

import de.daslaboratorium.machinelearning.classifier.bayes.BayesClassifier;
import org.junit.Test;

import java.util.Arrays;

public class NaiveBayesClassifierTest {

    @Test
    public void testHealthClassification() {
        String[] l8693 = "Auditory osseointegrated device abutment, any length, replacement only".split(" ");
        String[] l8695 = "External recharging system for battery (external) for use with implantable neurostimulator, replacement only".split(" ");
        String[] l8696 = "Antenna (external) for use with implantable diaphragmatic/phrenic nerve stimulation device, replacement, each".split(" ");
        String[] l8699 = "Prosthetic implant, not otherwise specified".split(" ");
        String[] l8606 = "ACL full Knee reconstruction (Left), Injectable bulking agent, synthetic implant, urinary tract, 1 ml syringe, includes shipping and necessary supplies".split(" ");
        String[] l8607 = "Injectable bulking agent for vocal cord medialization, 0.1 ml, includes shipping and necessary supplies".split(" ");
        String[] l8614 = "Cochlear device, includes all internal and external components".split(" ");

        String input = "Left Knee ACL reconstruction on 8/3/17  Status: Complete  Done: 01Aug2017\n" +
                "Ordered;For: Knee injury; Ordered By: Alex Alex Performed:  Due: 10Aug2017; Last Updated By: Mike, Mike; 08/01/2017 1:07:37 : ACL & mensicus tears";

        String input2 = "Left Knee ACL reconstruction";

        BayesClassifier classifier = new BayesClassifier();
        classifier.learn("l8693", Arrays.asList(l8693));
        classifier.learn("l8695", Arrays.asList(l8695));
        classifier.learn("l8696", Arrays.asList(l8696));
        classifier.learn("l8699", Arrays.asList(l8699));
        classifier.learn("l8606", Arrays.asList(l8606));
        classifier.learn("l8607", Arrays.asList(l8607));
        classifier.learn("l8614", Arrays.asList(l8614));
        classifier.learn("l8606", Arrays.asList("Left Knee ACL reconstruction on 8/3/17  Status: Complete  Done: 01Aug2017".split(" ")));

        System.out.println(classifier.classify(Arrays.asList(input.split(" "))).getCategory());


    }
}
