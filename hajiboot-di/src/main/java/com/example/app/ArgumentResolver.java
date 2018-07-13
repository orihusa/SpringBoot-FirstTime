// 2.1.2
package com.example.app;

import java.io.InputStream;

public interface ArgumentResolver {
	Argument resolve(InputStream stream);
}
