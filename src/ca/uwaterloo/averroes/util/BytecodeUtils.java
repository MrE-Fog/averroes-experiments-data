package ca.uwaterloo.averroes.util;

import java.util.Arrays;
import java.util.List;

import soot.ResolutionFailedException;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.Type;
import soot.coffi.Util;

public class BytecodeUtils {

	/**
	 * Get the parameter types of a method from its descriptor.
	 * 
	 * @param methodDescriptor
	 * @return
	 */
	public static List<Type> getParameterTypes(String methodDescriptor) {
		Type[] types = Util.v().jimpleTypesOfFieldOrMethodDescriptor(methodDescriptor);
		return Arrays.asList(types).subList(0, types.length - 1);
	}

	/**
	 * Get the return type of a method from its descriptor.
	 * 
	 * @param methodDescriptor
	 * @return
	 */
	public static Type getReturnType(String methodDescriptor) {
		Type[] types = Util.v().jimpleTypesOfFieldOrMethodDescriptor(methodDescriptor);
		return types[types.length - 1];
	}

	/**
	 * Resolve the given bits of a method signature to the corresponding SootMethod from the Soot Scene.
	 * 
	 * @param className
	 * @param methodName
	 * @param methodDescriptor
	 * @return
	 */
	public static SootMethod asSootMethod(String className, String methodName, String methodDescriptor) {
		SootClass cls = Scene.v().getSootClass(className);

		List<Type> parameterTypes = getParameterTypes(methodDescriptor);
		Type returnType = getReturnType(methodDescriptor);

		/*
		 * Get the method ref and resolve it to a Soot method. We need to resolve to the actual method that will be
		 * called at runtime, or might be resolved by a static analysis. Otherwise, we'll just get the interface method.
		 */
		SootMethodRef methodRef = Scene.v().makeMethodRef(cls, methodName, parameterTypes, returnType, false);
		SootMethod method;

		/*
		 * We have to do this ugly code. Try first and see if the method is not static. If it is static, then create a
		 * new methodRef in the catch and resolve it again with isStatic = true.
		 */
		try {
			method = methodRef.resolve();
		} catch (ResolutionFailedException e) {
			methodRef = Scene.v().makeMethodRef(cls, methodName, parameterTypes, returnType, true);
		}
		method = methodRef.resolve();

		return method;
	}
}
