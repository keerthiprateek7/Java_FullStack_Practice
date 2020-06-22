/*
 * Hibernate Validator, declare and validate application constraints
 *
 * License: Apache License, Version 2.0
 * See the license.txt file in the root directory or <http://www.apache.org/licenses/LICENSE-2.0>.
 */
package org.hibernate.validator.internal.engine.valueextraction;

import javax.validation.valueextraction.ExtractedValue;
import javax.validation.valueextraction.ValueExtractor;

import org.hibernate.validator.internal.engine.path.NodeImpl;

class IntArrayValueExtractor implements ValueExtractor<int @ExtractedValue[]> {

	static final ValueExtractorDescriptor DESCRIPTOR = new ValueExtractorDescriptor( new IntArrayValueExtractor() );

	private IntArrayValueExtractor() {
	}

	@Override
	public void extractValues(int[] originalValue, ValueReceiver receiver) {
		for ( int i = 0; i < originalValue.length; i++ ) {
			receiver.indexedValue( NodeImpl.ITERABLE_ELEMENT_NODE_NAME, i, originalValue[i] );
		}
	}
}
