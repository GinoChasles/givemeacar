import React from 'react'


import { useTranslate } from "react-admin";

import {
    PasswordInput,
    required,
    regex,
    minLength,
    maxLength
} from "react-admin";

const validateRegex = /\+?[0-9]{10,12}/;

export default function Phone() {

    const t = useTranslate();

    return <PasswordInput source="password" label={t('word.password')}
        validate={[
            required(t('error.required'))
        ]}
    />
}
