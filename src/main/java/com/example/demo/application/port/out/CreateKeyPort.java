package com.example.demo.application.port.out;

import com.example.demo.application.domain.Key;

public interface CreateKeyPort {
    Key save(Key key);
}
