package br.com.p8.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.p8.exception.UnsuportedMathOperatinException;
import br.com.p8.request.converters.NumberConverter;

@RestController
public class MathController {
	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}",method = RequestMethod.GET)
	public Double sum(@PathVariable(value="numberOne") String numberOne, @PathVariable(value="numberTwo") String numberTwo) throws Exception {
		
		if (!NumberConverter.isNumeric(numberOne)||!NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperatinException("Please set a numeric value");
			
		}
		Double sum = NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(numberTwo);
		return sum;
		
	}
	
	@RequestMapping(value="/minus/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double minus(@PathVariable(value="numberOne") String numberOne, @PathVariable(value="numberTwo") String numberTwo) throws Exception{
		if (!NumberConverter.isNumeric(numberOne)||!NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperatinException("Please set a numeric value");
			
		}
		Double minus = NumberConverter.convertToDouble(numberOne) - NumberConverter.convertToDouble(numberTwo);
		return minus;
	}
	
	@RequestMapping(value="/multiple/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiple(@PathVariable(value="numberOne") String numberOne, @PathVariable(value="numberTwo") String numberTwo) throws Exception{
		if (!NumberConverter.isNumeric(numberOne)||!NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperatinException("Please set a numeric value");
			
		}
		Double multiple = NumberConverter.convertToDouble(numberOne) * NumberConverter.convertToDouble(numberTwo);
		return multiple;
	}
	
	@RequestMapping(value="/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double division(@PathVariable(value="numberOne") String numberOne, @PathVariable(value="numberTwo") String numberTwo) throws Exception{
		if (!NumberConverter.isNumeric(numberOne)||!NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperatinException("Please set a numeric value");
			
		}
		Double division = NumberConverter.convertToDouble(numberOne) / NumberConverter.convertToDouble(numberTwo);
		return division;
	}
	
	@RequestMapping(value="/average/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double average(@PathVariable(value="numberOne") String numberOne, @PathVariable(value="numberTwo") String numberTwo) throws Exception{
		if (!NumberConverter.isNumeric(numberOne)||!NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperatinException("Please set a numeric value");
			
		}
		Double average =  (NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(numberTwo))/2;
		return average;
	}
	
	@RequestMapping(value="/sqrt/{numberOne}", method = RequestMethod.GET)
	public Double sqrt(@PathVariable(value="numberOne") String numberOne) throws Exception{
		if (!NumberConverter.isNumeric(numberOne)) {
			throw new UnsuportedMathOperatinException("Please set a numeric value");
			
		}
		Double sqrt = Math.sqrt(NumberConverter.convertToDouble(numberOne));
		return sqrt;
	}
	

	
}
