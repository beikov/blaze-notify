/*
 * Copyright 2018 Blazebit.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.blazebit.notify.expression;

import com.blazebit.notify.domain.runtime.model.DomainType;
import com.blazebit.notify.domain.runtime.model.ResolvedLiteral;

import java.util.Objects;

public class Atom implements ArithmeticExpression {
    private final Attribute attribute;
    private final FunctionInvocation functionInvocation;
    private final ResolvedLiteral literal;

    public Atom(Attribute attribute) {
        this.attribute = attribute;
        this.functionInvocation = null;
        this.literal = null;
    }

    public Atom(FunctionInvocation functionInvocation) {
        this.attribute = null;
        this.functionInvocation = functionInvocation;
        this.literal = null;
    }

    public Atom(ResolvedLiteral literal) {
        this.attribute = null;
        this.functionInvocation = null;
        this.literal = literal;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public FunctionInvocation getFunctionInvocation() {
        return functionInvocation;
    }

    public ResolvedLiteral getLiteral() {
        return literal;
    }

    @Override
    public DomainType getType() {
        return attribute == null ? (literal == null ? functionInvocation.getType() : literal.getType()) : attribute.getType();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public <T> T accept(ResultVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atom atom = (Atom) o;
        return Objects.equals(attribute, atom.attribute) &&
                Objects.equals(functionInvocation, atom.functionInvocation) &&
                Objects.equals(literal, atom.literal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attribute, functionInvocation, literal);
    }
}
