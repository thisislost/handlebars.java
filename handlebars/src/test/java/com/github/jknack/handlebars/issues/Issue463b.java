/*
 * Handlebars.java: https://github.com/jknack/handlebars.java
 * Apache License Version 2.0 http://www.apache.org/licenses/LICENSE-2.0
 * Copyright (c) 2012 Edgar Espina
 */
package com.github.jknack.handlebars.issues;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.v4Test;

public class Issue463b extends v4Test {

  @Override
  protected void configure(final Handlebars handlebars) {
    handlebars.parentScopeResolution(true);
  }

  @Test
  public void parentScopeResolution() throws IOException {
    shouldCompileTo(
        "Hello {{#child}}{{value}}{{bestQB}}{{/child}}",
        $("hash", $("value", "Brett", "child", $("bestQB", "Favre"))),
        "Hello BrettFavre");
  }
}
