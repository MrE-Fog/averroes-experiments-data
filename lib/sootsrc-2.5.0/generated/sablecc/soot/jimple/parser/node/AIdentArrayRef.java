/* This file was generated by SableCC (http://www.sablecc.org/). */

package soot.jimple.parser.node;

import soot.jimple.parser.analysis.*;

@SuppressWarnings("nls")
public final class AIdentArrayRef extends PArrayRef
{
    private TIdentifier _identifier_;
    private PFixedArrayDescriptor _fixedArrayDescriptor_;

    public AIdentArrayRef()
    {
        // Constructor
    }

    public AIdentArrayRef(
        @SuppressWarnings("hiding") TIdentifier _identifier_,
        @SuppressWarnings("hiding") PFixedArrayDescriptor _fixedArrayDescriptor_)
    {
        // Constructor
        setIdentifier(_identifier_);

        setFixedArrayDescriptor(_fixedArrayDescriptor_);

    }

    @Override
    public Object clone()
    {
        return new AIdentArrayRef(
            cloneNode(this._identifier_),
            cloneNode(this._fixedArrayDescriptor_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAIdentArrayRef(this);
    }

    public TIdentifier getIdentifier()
    {
        return this._identifier_;
    }

    public void setIdentifier(TIdentifier node)
    {
        if(this._identifier_ != null)
        {
            this._identifier_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._identifier_ = node;
    }

    public PFixedArrayDescriptor getFixedArrayDescriptor()
    {
        return this._fixedArrayDescriptor_;
    }

    public void setFixedArrayDescriptor(PFixedArrayDescriptor node)
    {
        if(this._fixedArrayDescriptor_ != null)
        {
            this._fixedArrayDescriptor_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._fixedArrayDescriptor_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._identifier_)
            + toString(this._fixedArrayDescriptor_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._identifier_ == child)
        {
            this._identifier_ = null;
            return;
        }

        if(this._fixedArrayDescriptor_ == child)
        {
            this._fixedArrayDescriptor_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._identifier_ == oldChild)
        {
            setIdentifier((TIdentifier) newChild);
            return;
        }

        if(this._fixedArrayDescriptor_ == oldChild)
        {
            setFixedArrayDescriptor((PFixedArrayDescriptor) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
