

package com.dhenton9000.groovy.basic

import groovy.xml.MarkupBuilder

/**
 *
 * @author dhenton
 */
class ImportTests extends GroovyTestCase {
    
    
    void testImport()
    {
        def xml = new MarkupBuilder()
        assert (xml != null)
    }
}

