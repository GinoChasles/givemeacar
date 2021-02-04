import React from 'react'


import { useTranslate } from "react-admin";

import {
    TextInput,
    required,
    regex,
    minLength,
    maxLength
} from "react-admin";

const validateRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$/;

export default function Mail() {

    const t = useTranslate();

    return <TextInput source="mail" label={t('word.mail')}
        validate={[
            required(t('error.required')),
            regex(validateRegex, t('error.regex')),
            minLength(6),
            maxLength(64),
        ]}

    />
}
