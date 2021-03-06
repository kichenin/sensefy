/**
 * (C) Copyright 2015 Zaizi Limited (http://www.zaizi.com).
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 3.0 which accompanies this distribution, and is available at 
 * http://www.gnu.org/licenses/lgpl-3.0.en.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
  **/
package org.zaizi.sensefy.auth.error;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@Controller
public class WhitelabelErrorController implements ErrorController {

	private static final String PATH = "/error";

	@RequestMapping(value = PATH)
	public String error(Model model) {
		model.addAttribute("timestamp", "12345678");
		model.addAttribute("error", "error type");
		model.addAttribute("status", "status of the error");
		model.addAttribute("message", "description of the error");
		return "error/error";
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}

}
