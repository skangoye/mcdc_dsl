/*
 * generated by Xtext
 */
package org.xtext.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import org.xtext.ui.internal.ModuleDslActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class ModuleDslExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return ModuleDslActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return ModuleDslActivator.getInstance().getInjector(ModuleDslActivator.ORG_XTEXT_MODULEDSL);
	}
	
}