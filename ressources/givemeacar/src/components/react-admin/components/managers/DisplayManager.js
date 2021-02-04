import {
    Datagrid, Filter, List, SearchInput, TextField, useTranslate
} from "react-admin";
import * as React from "react";

const PostFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
    </Filter>
);

const DisplayManager = (props) => {

    const t = useTranslate();

    return <List {...props} title={t('custom.manager')} filters={<PostFilter />}>
        <Datagrid rowClick="edit">

            <TextField label={t('custom.id')} source="id" />

            <TextField label={t('custom.name')} source="name" />

            <TextField label={t('custom.brand')} source="brandName" />

        </Datagrid>
    </List>
}
export default DisplayManager