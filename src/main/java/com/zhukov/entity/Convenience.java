package com.zhukov.entity;

public enum Convenience {
    Comfortable,
    Uncomfortable;

    public boolean isComfortable() {
        return equals(Convenience.Comfortable);
    }
}
