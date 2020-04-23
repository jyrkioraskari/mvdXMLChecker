package org.opensource_bimserver.bcf;

@SuppressWarnings("serial")
public class BcfException extends Exception {

        public BcfException(String message) {
                super(message);
        }

        public BcfException(Exception e) {
                super(e);
        }
}