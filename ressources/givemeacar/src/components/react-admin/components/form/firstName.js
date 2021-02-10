import React from 'react'


import { useTranslate } from "react-admin";

import {
    TextInput,
    required,
    regex,
    minLength,
    maxLength
} from "react-admin";

const validateRegex = /[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]{2,32}/;

export default function FirstName() {

    const t = useTranslate();

    return <TextInput source="firstName" label={t('word.firstName')}
        validate={[
            required(t('error.required')),
            regex(validateRegex, t('error.regex')),
            minLength(2),
            maxLength(32),
        ]}

    />
}
