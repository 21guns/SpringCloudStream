package cn.com.sina.alan.b.in;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.converter.AbstractMessageConverter;
import org.springframework.messaging.converter.MessageConversionException;
import org.springframework.util.MimeType;

/**
 * @author Ilayaperumal Gopinathan
 */
@Configuration
public class Converters {

	//Register custom converter
	@Bean
	public AbstractMessageConverter fooConverter() {
		return new FooToBarConverter();
	}

	public static class Foo {

		private String value = "foo";

		public String getValue() {
			return this.value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}

	public static class Bar {

		private String value = "init";

		public Bar(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}

		public void setValue(String value) {
			this.value = value;
		}

	}

	public static class FooToBarConverter extends AbstractMessageConverter {

		public FooToBarConverter() {
			super(new MimeType("application", "bar"));

		}

		@Override
		protected boolean supports(Class<?> clazz) {
			return (Bar.class == clazz);
		}

		@Override
		public Object convertFromInternal(Message<?> message, Class<?> targetClass, Object conversionHint) {
			Object result = null;
			try {
				if (message.getPayload() instanceof Foo) {
					Foo fooPayload = (Foo) message.getPayload();
					result = new Bar(fooPayload.getValue());
				}
			}
			catch (Exception e) {
				logger.error(e.getMessage(), e);
				throw new MessageConversionException(e.getMessage());
			}
			return result;
		}
	}
}
