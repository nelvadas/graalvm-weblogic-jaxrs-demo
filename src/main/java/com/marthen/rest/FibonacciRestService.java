package com.marthen.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

@Path("/fibonacci")
public class FibonacciRestService {
 
	@GET
	@Path("/{parameter}")
	public Response fibonacci(@PathParam("parameter") final int parameter) {

		long result = 0; 
		long begin = System.currentTimeMillis();
		result = Stream.iterate( new int[]{0,1}, fib-> new int[]{fib[1], fib[0]+fib[1]} )
				.limit(parameter)
				.map(x->x[0])
				.max(Comparator.naturalOrder())
				.get()
				.longValue();

		long processTime = System.currentTimeMillis() - begin;
		String output = "Time taken to complete in milliseconds: " + processTime + " ; and Fib("+parameter+") is: " + result;
		return Response.status(200).entity (output).build();	
  }
 
}